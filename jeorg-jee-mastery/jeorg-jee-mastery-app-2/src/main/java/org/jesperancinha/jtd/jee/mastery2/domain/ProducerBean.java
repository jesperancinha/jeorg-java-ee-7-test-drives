package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.UUID;

@Named
@SessionScoped
public class ProducerBean implements Serializable {

    @Inject
    private ProducerDAO producerDAO;

    private Producer producer;

    private Producer2 producer2;

    public ProducerBean(){
        producer = new Producer();
        producer.setName("Warner Music Group");
        final ProducerId producerId = new ProducerId();
        producerId.setInitials("WMG");
        producer.setProducerId(producerId);
        producer2 = new Producer2();
        producer2.setName("Warner Music Group");
        producer2 .setInitials("WMG");
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Producer2 getProducer2() {
        return producer2;
    }

    public void setProducer2(Producer2 producer2) {
        this.producer2 = producer2;
    }

    public void submitProducer() {
        final ProducerId producerId = producer.getProducerId();
        producerId.setUuid(UUID.randomUUID());
        producer.setProducerId(producerId);
        producerDAO.createNewProducer(producer);
    }

    public void submitProducer2() {
        producer2.setUuid(UUID.randomUUID());
        producerDAO.createNewProducer2(producer2);
    }
}
