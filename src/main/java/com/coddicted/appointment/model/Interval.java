package com.coddicted.appointment.model;

import lombok.Data;

import java.time.LocalTime;

@Data
public class Interval {
    private LocalTime startTime;
    private LocalTime endTime;
}
