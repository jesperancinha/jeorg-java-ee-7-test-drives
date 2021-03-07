package org.jesperancinha.jtd.jee.mastery1.beans;

import org.jesperancinha.jtd.jee.mastery1.domain.StoreRecordDao;
import org.jesperancinha.jtd.jee.mastery1.messaging.RecordWarehouse;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_CYAN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

/**
 * Session scoped need always to be Serializable
 */
@Named
@SessionScoped
public class RecordSenderDurable implements Serializable {

    public static final String SUBSCRIPTION_RECORDS_ID = "RecordsId";
    @Resource(lookup = "java:/jms/RecordsDurableFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/RecordsDurableTopic")
    private Topic topic;

    @Inject
    private StoreRecordDao storeRecordDao;

    @Inject
    private RecordWarehouse recordWarehouse;

    private List<Record> exampleRecords;

    private Record newRecord;

    private Record lastRecord;

    RecordSenderDurable() {
        final var record1 = new Record();
        record1.setArtist("Divine");
        record1.setName("The story so far");
        record1.setType("LP");
        record1.setYear("1984");
        final var record2 = new Record();
        record2.setArtist("Helene Fischer");
        record2.setName("Farbenspiel");
        record2.setType("LP");
        record2.setYear("2013");
        final var record3 = new Record();
        record3.setArtist("Dead or Alive");
        record3.setName("Youthquake");
        record3.setType("LP");
        record3.setYear("1985");
        this.exampleRecords = Arrays.asList(record1, record2, record3);
        this.newRecord = exampleRecords.get((int) (Math.random() * this.exampleRecords.size()));
    }

    public void setNewRecord(Record newRecord) {
        this.newRecord = newRecord;
    }

    public Record getNewRecord() {
        this.newRecord = exampleRecords.get((int) (Math.random() * this.exampleRecords.size()));
        return newRecord;
    }

    public void sendRecord() {
        BLUE.printGenericLn("Sending record %s", newRecord);
        BRIGHT_MAGENTA.printGenericLn("We are using cart %s with hash %s", this.getClass(), this.hashCode());
        try (JMSContext jmsContext = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
            jmsContext.setClientID("ID1");
            final JMSConsumer jmsConsumer = jmsContext.createDurableConsumer(topic, SUBSCRIPTION_RECORDS_ID);
            try {
                final Message receive = jmsConsumer.receive(1000);
                final Record record = (Record) ((ObjectMessage) receive).getObject();
                this.lastRecord = record;
                recordWarehouse.getRecordList().add(record);
                BRIGHT_CYAN.printGenericTitleLn(record);
                GREEN.printGenericTitleLn("Remember that the subscription is always the same once its created -> %s", SUBSCRIPTION_RECORDS_ID);
            } catch (Exception exception) {
                RED.printGenericLn("This is expected! For the first time that is -> %s", exception.getMessage());
            }
            jmsConsumer.close();
            final JMSProducer producer = jmsContext.createProducer();
            ObjectMessage message = jmsContext.createObjectMessage(newRecord);
            producer.send(topic, message);
        }
    }

    public List<Record> getExampleRecords() {
        return exampleRecords;
    }

    public void setExampleRecords(List<Record> exampleRecords) {
        this.exampleRecords = exampleRecords;
    }

    public Record getLastRecord() {
        return lastRecord;
    }

    public void setLastRecord(Record lastRecord) {
        this.lastRecord = lastRecord;
    }
}
