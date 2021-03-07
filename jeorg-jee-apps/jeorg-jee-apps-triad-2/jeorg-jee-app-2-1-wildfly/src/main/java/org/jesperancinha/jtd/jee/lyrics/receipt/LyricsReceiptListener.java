package org.jesperancinha.jtd.jee.lyrics.receipt;

import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "java:/jms/LyricsReceiptQueue")})
public class LyricsReceiptListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                BLUE.printGenericTitleLn("Received a message!");
                ORANGE.printGenericLn(textMessage.getText());
                ConsolerizerGraphs.printUnicornsLn(100);
                message.acknowledge();
            } catch (Exception ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
}