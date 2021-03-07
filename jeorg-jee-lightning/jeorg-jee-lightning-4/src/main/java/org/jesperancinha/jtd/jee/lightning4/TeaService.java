package org.jesperancinha.jtd.jee.lightning4;

import org.jesperancinha.console.consolerizer.console.Consolerizer;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Topic;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@Named
@RequestScoped
public class TeaService {
    @Resource(lookup = "java:/TeaQueueFactory/TeaQueueFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/TeaTopic")
    private Topic topic;

    private String tea1;

    private String tea2;

    public void action() throws JMSException {

        Consolerizer.setupFastDefault();

        try (JMSContext ctx = connectionFactory.createContext(JMSContext.SESSION_TRANSACTED)) {

            JMSConsumer c1 = ctx.createConsumer(topic, "quality > 5");
            JMSConsumer c2 = ctx.createConsumer(topic, "quality <= 5");

            final JMSProducer producer = ctx.createProducer();

            final Tea green = new Tea("Green", 10L);
            final Tea black = new Tea("Black", 1L);
            final ObjectMessage message1 = ctx.createObjectMessage(green);
            message1.setLongProperty("quality", green.getQuality());
            final ObjectMessage message2 = ctx.createObjectMessage(black);
            message2.setLongProperty("quality", black.getQuality());
            producer.send(topic, message1);
            producer.send(topic, message2);
            ctx.commit();
            final Message receive = c1.receive(1000);
            final Message receive1 = c2.receive(1000);

            final Tea tea1 = receive.getBody(Tea.class);
            ORANGE.printGenericLn(tea1);
            final Tea tea2 = receive1.getBody(Tea.class);
            MAGENTA.printGenericLn(tea2);
            ctx.acknowledge();

            this.tea1 = tea1.toString();
            this.tea2 = tea2.toString();
        }
    }

    public String getTea1() {
        return tea1;
    }

    public String getTea2() {
        return tea2;
    }

    public void setTea1(String tea1) {
        this.tea1 = tea1;
    }

    public void setTea2(String tea2) {
        this.tea2 = tea2;
    }
}
