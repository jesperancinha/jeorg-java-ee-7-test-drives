package org.jesperancinha.jtd.jee.mastery1.scopes;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static org.jesperancinha.jtd.jee.mastery1.beans.Record.allRecordExamples;

@Named
@SessionScoped
public class RecordSessionBean implements Serializable {

    private Record rec;

    public RecordSessionBean() {
        this.rec = getRecord();
    }

    public Record getRec() {
        return rec;
    }

    public void setRec(Record rec) {
        this.rec = rec;
    }

    public Record getRecord() {
        final List<Record> records = allRecordExamples();
        return records.get((int) (Math.random() * records.size()));
    }

}
