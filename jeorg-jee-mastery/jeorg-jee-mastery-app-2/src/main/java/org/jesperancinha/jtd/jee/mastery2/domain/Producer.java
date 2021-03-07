package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Producer {

    @EmbeddedId
    private ProducerId producerId;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducerId(ProducerId producerId) {
        this.producerId = producerId;
    }

    public ProducerId getProducerId() {
        return producerId;
    }
}
