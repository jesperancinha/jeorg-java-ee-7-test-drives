package org.jesperancinha.jtd.jee.mastery1.messaging;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",
                propertyValue = "java:/jms/TicketsQueue"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue")
})
public class TicketReceiver implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                GREEN.printSyncGenericTitleLn(message.getBody(String.class));
            } else {
                MAGENTA.printSyncGenericTitleLn(message.getClass().getName());
            }
        } catch (JMSException e) {
            RED.printSyncGenericLn(e);
            mdc.setRollbackOnly();
        }
    }
}
