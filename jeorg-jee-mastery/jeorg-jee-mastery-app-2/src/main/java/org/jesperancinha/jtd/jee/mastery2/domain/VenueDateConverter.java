package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.persistence.AttributeConverter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VenueDateConverter implements AttributeConverter<LocalDateTime, String> {

    @Override
    public String convertToDatabaseColumn(LocalDateTime localDateTime) {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(String dbData) {
        return LocalDateTime.parse(dbData, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
