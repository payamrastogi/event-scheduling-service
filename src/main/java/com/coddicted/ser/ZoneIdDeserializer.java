package com.coddicted.ser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.ZoneId;

public class ZoneIdDeserializer extends StdDeserializer<ZoneId> {

    public ZoneIdDeserializer() {
        this(null);
    }

    public ZoneIdDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ZoneId deserialize(
            JsonParser jsonparser, DeserializationContext context)
            throws IOException {
        String zoneId = jsonparser.getText();
        return ZoneId.of(zoneId);

    }
}
