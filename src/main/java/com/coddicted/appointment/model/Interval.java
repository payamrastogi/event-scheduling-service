package com.coddicted.appointment.model;

import com.coddicted.ser.ZoneIdDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZoneIdSerializer;
import lombok.Data;

import java.time.LocalTime;

@Data
public class Interval {
    private LocalTime startTime;
    private LocalTime endTime;
}
