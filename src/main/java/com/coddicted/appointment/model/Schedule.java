package com.coddicted.appointment.model;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Data
public class Schedule {
    private String id;
    private String name;
    private TimeZone timeZone;
    private Map<DayOfWeek, List<Interval>> availabilityMap;
    private Map<LocalDate, List<Interval>> overrideList;
}
