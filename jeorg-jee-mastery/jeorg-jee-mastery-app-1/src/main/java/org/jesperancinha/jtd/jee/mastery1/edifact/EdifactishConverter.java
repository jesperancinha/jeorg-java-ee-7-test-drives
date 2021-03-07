package org.jesperancinha.jtd.jee.mastery1.edifact;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EdifactishConverter implements AttributeConverter<Record, String> {
    @Override
    public String convertToDatabaseColumn(Record record) {
        return record.getName() +
                "+" +
                record.getArtist() +
                "+" +
                record.getYear() +
                "+" +
                record.getType();
    }

    @Override
    public Record convertToEntityAttribute(String dbData) {
        final String[] split = dbData.split("\\+");
        final Record record = new Record();
        record.setName(split[0]);
        record.setArtist(split[1]);
        record.setYear(split[2]);
        record.setType(split[3]);
        return record;
    }
}
