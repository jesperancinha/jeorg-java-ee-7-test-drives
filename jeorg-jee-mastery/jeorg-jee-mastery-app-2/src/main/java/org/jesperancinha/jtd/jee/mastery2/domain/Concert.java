package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table
public class Concert {

    @Id
    private UUID uuid;

    @Column
    private String name;

    @Column
    private Date date;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
