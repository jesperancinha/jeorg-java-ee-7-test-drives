package org.jesperancinha.jtd.jee.lyrics.noreceipt;

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

@WebServlet(urlPatterns = "/send/random-lyric")
public class LyricsServlet extends HttpServlet {

    @Inject
    private LyricsService lyricsService;

    @Resource(lookup = "java:/jms/LyricsQueueFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/LyricsQueue")
    private Destination destination;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        try {
            QueueConnection connection = (QueueConnection) connectionFactory.createConnection();
            try {
                QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
                try {
                    MessageProducer producer = session.createProducer(destination);
                    try {
                        final String randomLyric = lyricsService.getRandomLyric();
                        TextMessage message = session.createTextMessage(randomLyric);
                        producer.send(message);
                        writer.println("<p>Lyrics has been sent!</p>");
                        writer.println(String.format("<p>%s</p>", randomLyric));
                    } finally {
                        producer.close();
                    }
                } finally {
                    session.close();
                }

            } finally {
                connection.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace(writer);
        }
    }
}
