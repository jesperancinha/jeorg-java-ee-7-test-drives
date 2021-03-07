package org.jesperancinha.jtd.jee.lyrics.receipt;

import org.jesperancinha.jtd.jee.lyrics.service.LyricsService;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@WebServlet(urlPatterns = "/send/random-lyric/receipt")
public class LyricsServlet extends HttpServlet {

    @Inject
    private LyricsService lyricsService;

    @Resource(lookup = "java:/jms/LyricsQueueFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/LyricsReceiptQueue")
    private Destination destination;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        try {
            QueueConnection connection = (QueueConnection) connectionFactory.createConnection();
            try {
                QueueSession queueSession = connection.createQueueSession(false, Session.CLIENT_ACKNOWLEDGE);
                try {
                    MessageProducer producer = queueSession.createProducer(destination);
                    try {
                        final String randomLyric = lyricsService.getRandomLyric();
                        TextMessage message = queueSession.createTextMessage(randomLyric);
                        producer.send(message);
                        writer.println("<p>Lyrics has been sent!</p>");
                        writer.println(String.format("<p>%s</p>", randomLyric));
//                        message.acknowledge();
                        GREEN.printGenericLn("Acknowledge informs the queue that messages have been received");
                        GREEN.printGenericLn("In the case of CLIENT_ACKNOWLEDGE, messages are removed only when the client acknowledges receipt");
                        GREEN.printGenericLn("Check the listener. We are also calling an acknowledge there. This acknowledge is only letting the session know that a message has been sent!");
                    } finally {
                        producer.close();
                    }
                } finally {
                    queueSession.close();
                }

            } finally {
                connection.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace(writer);
        }
    }
}
