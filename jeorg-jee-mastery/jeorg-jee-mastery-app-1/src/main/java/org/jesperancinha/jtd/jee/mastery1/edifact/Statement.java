package org.jesperancinha.jtd.jee.mastery1.edifact;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "statement")
@Table
public class Statement {

    @Id
    private UUID uuid;

    @Column
    private Record record;

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Record getRecord() {
        return record;
    }
}
