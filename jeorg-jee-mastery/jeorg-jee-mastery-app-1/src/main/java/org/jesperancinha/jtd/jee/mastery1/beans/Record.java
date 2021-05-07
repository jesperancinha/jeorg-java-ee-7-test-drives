package org.jesperancinha.jtd.jee.mastery1.beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Record implements Serializable {
    private String name;

    private String type;

    private String year;

    private String artist;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", year='" + year + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }

    public static List<Record> allRecordExamples() {
        final var record0 = new Record();
        record0.setName("Humanos LP");
        record0.setArtist("Humanos");
        record0.setYear("2019");
        record0.setType("LP");
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
        final List<Record> records = Arrays.asList(
                record0, record1, record2, record3);
        return records;
    }
}
