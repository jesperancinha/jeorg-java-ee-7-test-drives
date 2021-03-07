package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public abstract class Merchandise {

    private String id;

    public void setId(String id) {

        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

}
