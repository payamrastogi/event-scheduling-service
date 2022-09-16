package com.coddicted.appointment.service;

import com.coddicted.appointment.model.Appointment;
import com.coddicted.appointment.model.AppointmentDetail;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

public interface AppointmentService {

    List<Appointment> getAppointments(String calendarId, LocalDate fromDate, LocalDate toDate);

    Appointment createAppointment(AppointmentDetail appointmentDetail, ZonedDateTime startDateTime, ZonedDateTime endDateTime);

//    boolean confirmAppointment(String id);
//    boolean declineAppointment(String id);
//    boolean cancelAppointment(String id);

}
