package org.jesperancinha.jtd.jee.mastery1.beans;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.jtd.jee.mastery1.domain.StoreRecord;
import org.jesperancinha.jtd.jee.mastery1.domain.StoreRecordDao;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Session scoped need always to be Serializable
 */
@Named
@SessionScoped
public class RegisterCart implements Serializable {

    @Inject
    private StoreRecordDao storeRecordDao;

    private List<Record> exampleRecords;

    private Record newRecord;

    RegisterCart() {
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
        this.newRecord = new Record();
    }

    public void setNewRecord(Record newRecord) {
        this.newRecord = newRecord;
    }

    public Record getNewRecord() {
        return newRecord;
    }

    public void saveRecord() {
        ConsolerizerColor.BRIGHT_MAGENTA.printGenericLn("We are using cart %s with hash %s", this.getClass(), this.hashCode());
        final StoreRecord album = new StoreRecord();
        album.setId(UUID.randomUUID());
        album.setArtist(newRecord.getArtist());
        album.setName(newRecord.getName());
        album.setYear(newRecord.getYear());
        storeRecordDao.createAlbum(album);
    }

    public List<Record> getExampleRecords() {
        return exampleRecords;
    }

    public void setExampleRecords(List<Record> exampleRecords) {
        this.exampleRecords = exampleRecords;
    }
}
