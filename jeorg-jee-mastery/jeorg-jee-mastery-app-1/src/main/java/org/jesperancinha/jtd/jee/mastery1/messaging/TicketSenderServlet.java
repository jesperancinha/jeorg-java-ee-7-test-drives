package org.jesperancinha.jtd.jee.mastery1.messaging;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@WebServlet("/ticketoffice")
public class TicketSenderServlet extends HttpServlet {

    @Resource(lookup = "java:/jms/TicketFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/TicketsQueue")
    private Queue queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            final Connection connection = connectionFactory.createConnection();
            final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            final Message message = session.createTextMessage("Sound Check!");
            final MessageProducer producer = session.createProducer(queue);
            connection.start();
            producer.send(message);
            session.commit();
            final PrintWriter writer = resp.getWriter();
            writer.println(ConsolerizerColor.GREEN.getPBText("Please check your logs!, there is some test checks under way..."));
            writer.println(MAGENTA.getPText("<p><a href=\"index.xhtml\">Back</a></p>"));
        } catch (JMSException e) {
            RED.printThrowableAndExit(e);
        }

    }
}
