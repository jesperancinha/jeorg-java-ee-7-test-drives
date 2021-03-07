package org.jesperancinha.jtd.jee.mastery1.scopes;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

import static org.jesperancinha.jtd.jee.mastery1.beans.Record.allRecordExamples;

@Named
@RequestScoped
public class RecordRequestBean {

    private Record rec;

    public RecordRequestBean() {
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
