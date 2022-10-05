package com.coddicted.appointment.model;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.TimeZone;

@Data
public class Appointment {
    private String id;
    private String calendarId;
    private String calendarOwnerId;
    private String appointmentOwnerId;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private TimeZone timeZone;
    private AppointmentStatus appointmentStatus;
    private AppointmentDetail appointmentDetail;
}
