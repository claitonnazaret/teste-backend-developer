package br.com.claiton.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private final DateTimeFormatter format = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    @Override
    public LocalDateTime deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException {
        return LocalDateTime.parse(arg0.getText(), format);
    }
}
