package com.coddicted.appointment.service.impl;

import com.coddicted.appointment.model.Appointment;
import com.coddicted.appointment.model.AppointmentDetail;
import com.coddicted.appointment.model.AppointmentStatus;
import com.coddicted.appointment.repository.AppointmentRepository;
import com.coddicted.appointment.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

//Todo 1: How to save all date time in UTC format
//Todo 2: Key=userid:year:month, value(HashTable)=[date, sorted set<Interval>]
//Todo 3: What if the appointment encompasses two dates

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;


    @Override
    public List<Appointment> getAppointments(String calendarId, LocalDate fromDate, LocalDate toDate) {
        return null;
    }

    @Override
    public Appointment createAppointment(AppointmentDetail appointmentDetail, ZonedDateTime startDateTime, ZonedDateTime endDateTime) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDetail(appointmentDetail);
        appointment.setAppointmentStatus(AppointmentStatus.SCHEDULED);
        appointment.setStartDateTime(startDateTime);
        appointment.setEndDateTime(endDateTime);
        try {
            saveAppointment(appointment);
            return appointment;
        } catch (Exception ex){
            return null;
        }
    }

    private Appointment saveAppointment(Appointment appointment) {
        appointmentRepository.addAppointment(appointment);
        return appointment;
    }

//    @Override
//    public boolean confirmAppointment(String id) {
//        return updateAppointmentStatus(id, AppointmentStatus.CONFIRMED);
//    }
//
//    @Override
//    public boolean declineAppointment(String id) {
//        return updateAppointmentStatus(id, AppointmentStatus.DECLINED);
//    }
//
//    @Override
//    public boolean cancelAppointment(String id) {
//        return updateAppointmentStatus(id, AppointmentStatus.CANCELLED);
//    }

//    private boolean updateAppointmentStatus(String id, AppointmentStatus appointmentStatus){
//        try {
//            Objects.requireNonNull(id);
//            Appointment appointment = this.getAppointmentById(id);
//            appointment.setAppointmentStatus(appointmentStatus);
//            saveAppointment(appointment);
//            return true;
//        } catch (Exception ex){
//            return false;
//        }
//    }
}
