package org.jesperancinha.jtd.jee.mastery1.edifact;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Session scoped need always to be Serializable
 */
@Named
@SessionScoped
public class RegisterCartEdifact implements Serializable {

    @Inject
    private StoreStatementDao storeStatementDao;

    private List<Record> exampleRecords;

    private List<Record> allRecords;

    private Record newRecord;

    RegisterCartEdifact() {
        final var record1 = new Record();
        record1.setArtist("Divine");
        record1.setName("The story so far");
        record1.setType("LP");
        record1.setYear("1984");
        final var record2 = new Record();
        record2.setArtist("Helene Fischer");
        record2.setName("Farbenspiel");
        record2.setType("LP");
        record2.setYear("2013");
        final var record3 = new Record();
        record3.setArtist("Dead or Alive");
        record3.setName("Youthquake");
        record3.setType("LP");
        record3.setYear("1985");
        this.exampleRecords = Arrays.asList(record1, record2, record3);
        this.newRecord = this.exampleRecords.get((int) (this.exampleRecords.size() * Math.random()));
    }

    public void setNewRecord(Record newRecord) {
        this.newRecord = newRecord;
    }

    public Record getNewRecord() {
        return newRecord;
    }

    public void saveRecord() {
        ConsolerizerColor.BRIGHT_MAGENTA.printGenericLn("We are using cart %s with hash %s", this.getClass(), this.hashCode());
        storeStatementDao.createRecordStatement(newRecord);
    }

    public List<Record> getExampleRecords() {
        return exampleRecords;
    }

    public void setExampleRecords(List<Record> exampleRecords) {
        this.exampleRecords = exampleRecords;
    }

    public List<Record> getAllRecords() {
        return storeStatementDao.getAllRecordStatements()
                .stream()
                .map(Statement::getRecord)
                .collect(Collectors.toList());
    }

    public void setAllRecords(List<Record> allRecords) {
        this.allRecords = allRecords;
    }
}
