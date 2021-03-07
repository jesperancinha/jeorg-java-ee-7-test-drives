package org.jesperancinha.jtd.jee.mastery1.edifact;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import java.io.Serializable;
import java.util.List;

public interface StoreStatementDao extends Serializable {
    Record getRecordStatementById(String id);

    void createRecordStatement(Record album);

    List<Statement> getAllRecordStatements();
}
