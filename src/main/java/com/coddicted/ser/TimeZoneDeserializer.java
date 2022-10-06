package com.coddicted.ser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.util.TimeZone;

public class TimeZoneDeserializer extends StdDeserializer<TimeZone> {

    public TimeZoneDeserializer() {
        this(null);
    }

    public TimeZoneDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public TimeZone deserialize(
            JsonParser jsonparser, DeserializationContext context)
            throws IOException {
        String timeZone = jsonparser.getText();
        return TimeZone.getTimeZone(timeZone);

    }
}
