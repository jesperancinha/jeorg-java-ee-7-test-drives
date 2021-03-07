package org.jesperancinha.jtd.jee.lyrics.durable;

import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Enumeration;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "java:/jms/LyricsDurableQueue")})
public class LyricsDurableListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            final Enumeration propertyNames = message.getPropertyNames();
            BLUE.printGenericLn(propertyNames);
        } catch (JMSException e) {
            RED.printExpectedException("We are just checking the properties", e);
        }
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                BLUE.printGenericTitleLn("Received a message!");
                ORANGE.printGenericLn(textMessage.getText());
                ConsolerizerGraphs.printUnicornsLn(100);
            } catch (Exception ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
}