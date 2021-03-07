package org.jesperancinha.jtd.jee.mastery1.scopes;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

import static org.jesperancinha.jtd.jee.mastery1.beans.Record.allRecordExamples;

@ViewScoped
@ManagedBean(name = "recordViewBean")
public class RecordViewBean implements Serializable {

    private Record rec;

    public RecordViewBean() {
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
