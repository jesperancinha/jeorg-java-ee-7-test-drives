package org.jesperancinha.jtd.jee.mastery1.messaging;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RecordWarehouse {

    private List<Record> recordList;

    RecordWarehouse() {
        this.recordList = new ArrayList<>();
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }
}
