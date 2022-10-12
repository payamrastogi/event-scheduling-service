package com.coddicted.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StringToLocalTime implements Converter<String, LocalTime> {
    @Override
    public LocalTime convert(String source) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(source, formatter);
    }
}
