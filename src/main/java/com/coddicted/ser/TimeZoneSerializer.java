//package com.coddicted.ser;
//
//public class TimeZoneSerializer extends StdSerializer<com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer> {
//
//    private static SimpleDateFormat formatter
//            = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//
//    public TimeZoneSerializer() {
//        this(null);
//    }
//
//    public TimeZoneSerializer(Class<Date> t) {
//        super(t);
//    }
//
//    @Override
//    public void serialize(
//            Date value, JsonGenerator gen, SerializerProvider arg2)
//            throws IOException, JsonProcessingException {
//        gen.writeString(formatter.format(value));
//    }
//}