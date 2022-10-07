package com.coddicted.appointment.model;

import com.coddicted.ser.ZoneIdDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZoneIdSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "schedules")
public class Schedule {
    @Id
    private String id;
    private String name;
    @JsonSerialize(using = ZoneIdSerializer.class)
    @JsonDeserialize(using = ZoneIdDeserializer.class)
    private ZoneId zoneId;
    private ScheduleType scheduleType;
    private Map<DayOfWeek, List<Interval>> availabilityMap;
    private Map<LocalDate, List<Interval>> unavailabilityMap;
}
