package com.coddicted.appointment.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Data
@Document(collection = "schedules")
public class Schedule {
    @Id
    private String id;
    private String name;
    private TimeZone timeZone;
    private ScheduleType scheduleType;
    private Map<DayOfWeek, List<Interval>> availabilityMap;
    private Map<LocalDate, List<Interval>> unavailabilityMap;
}
