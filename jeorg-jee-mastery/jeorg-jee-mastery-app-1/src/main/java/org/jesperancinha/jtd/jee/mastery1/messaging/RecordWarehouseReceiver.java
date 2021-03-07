package org.jesperancinha.jtd.jee.mastery1.messaging;

import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;
import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "java:/jms/RecordsTopic")})
public class RecordWarehouseReceiver implements MessageListener {

    @Inject
    private RecordWarehouse recordWarehouse;

    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
                BLUE.printGenericTitleLn("Received a message!");
                final Serializable object = objectMessage.getObject();
                ORANGE.printGenericLn(object);
                ConsolerizerGraphs.printUnicornsLn(100);
                recordWarehouse.getRecordList().add((Record) object);
            } catch (Exception ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
}