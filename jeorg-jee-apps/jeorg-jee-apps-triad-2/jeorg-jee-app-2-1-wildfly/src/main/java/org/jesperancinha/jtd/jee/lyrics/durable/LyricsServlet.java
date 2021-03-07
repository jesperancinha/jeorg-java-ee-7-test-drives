package org.jesperancinha.jtd.jee.lyrics.durable;

import org.jesperancinha.jtd.jee.lyrics.service.LyricsService;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@WebServlet(urlPatterns = "/send/random-lyric/durable")
public class LyricsServlet extends HttpServlet {

    @Inject
    private LyricsService lyricsService;

    @Resource(lookup = "java:/jms/LyricsQueueFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/LyricsQueue")
    private Destination destination;

    @Resource(lookup = "java:/jms/LyricsTopic")
    private Topic topic;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        try {
            JMSContext jmsContext = connectionFactory.createContext();
            try {
                final String clientID = UUID.randomUUID()
                        .toString();
                try {
                    jmsContext.setClientID(clientID);
                } catch (Exception e) {
                    GREEN.printGenericLn(e);
                }
                JMSConsumer consumer = jmsContext.createDurableConsumer(topic, "LYRICS_CONSUMER");

                JMSProducer producer = jmsContext.createProducer();

                for (int i = 0; i < 5; i++) {
                    TextMessage message = jmsContext.createTextMessage();
                    message.setText(lyricsService.getRandomLyric());
                    producer.send(topic, message);
                }
                final Message receive = consumer.receive();
                writer.println(receive);
                writer.println(((TextMessage) receive).getText());
                if (jmsContext != null)
                    jmsContext.close();
                writer.println("PublishMessage Completed <br>");

                writer.println("<h1>And now we create another consumer</h1>");

                jmsContext = connectionFactory.createContext();
                try {
                    jmsContext.setClientID(clientID);
                } catch (Exception e) {

                }
                consumer = jmsContext.createDurableConsumer(topic, "LYRICS_CONSUMER");
                try {
                    Message message;
                    writer.println("*********");
                    message = consumer.receive(1000);
                    writer.println(message);
                    while ((message = consumer.receive(1000)) != null) {
                        writer.println("------------");
                        writer.println(message);
                    }
                } catch (Exception e) {

                }
                writer.println("Re-reading Completed <br>");
                GREEN.printGenericLn("The client Id must match in order to resume operartions once the jmsContext is restarted");
            } finally {
                jmsContext.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace(writer);
        }
    }
}
