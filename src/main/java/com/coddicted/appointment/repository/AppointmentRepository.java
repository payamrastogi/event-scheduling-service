package com.coddicted.appointment.repository;

import com.coddicted.appointment.model.Appointment;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

@Repository
public class AppointmentRepository {
    private static ConcurrentHashMap<String, ConcurrentSkipListMap<LocalDate, SortedSet<Appointment>>> appointmentMap;

    public AppointmentRepository(){
        this.appointmentMap = new ConcurrentHashMap<>();
    }

    public void addAppointment(Appointment appointment){
        String key = getKey(appointment);
        LocalDate localDate = getLocalDate(appointment.getStartDateTime());
        ConcurrentSkipListMap<LocalDate, SortedSet<Appointment>> appointmentList
                = appointmentMap.getOrDefault(key,
                new ConcurrentSkipListMap<>(LocalDate::compareTo));

        SortedSet<Appointment> sortedSet = appointmentList.getOrDefault(localDate, new TreeSet<>(new Comparator<Appointment>() {
            @Override
            public int compare(Appointment a, Appointment b) {
                int res = a.getStartDateTime().compareTo(b.getStartDateTime());
                if(res==0){
                    res = b.getEndDateTime().compareTo(a.getEndDateTime());
                }
                return res;
            }
        }));

        sortedSet.add(appointment);
        appointmentList.put(localDate, sortedSet);
        appointmentMap.put(key, appointmentList);
    }

    public List<Appointment> getAppointments(String calendarId, LocalDate fromDate, LocalDate toDate){
        List<Appointment> res = new ArrayList<>();
        String key = getKey(calendarId, getYear(fromDate), getMonth(fromDate));
        ConcurrentSkipListMap<LocalDate, SortedSet<Appointment>> appointmentList = appointmentMap.get(key);
        for(LocalDate i = fromDate; i.isBefore(toDate) || i.isEqual(toDate); i.plusDays(1)){
            res.addAll(new ArrayList<>(appointmentList.get(i)));
        }
        return res;
    }

    private int getMonth(ZonedDateTime zonedDateTime){
        return zonedDateTime.getMonthValue();
    }

    private int getMonth(LocalDate localDate){
        return localDate.getMonthValue();
    }

    private int getYear(ZonedDateTime zonedDateTime){
        return zonedDateTime.getYear();
    }

    private int getYear(LocalDate localDate){
        return localDate.getYear();
    }

    private String getKey(Appointment appointment){
        Objects.requireNonNull(appointment);
        Objects.requireNonNull(appointment.getCalendarId());
        Objects.requireNonNull(appointment.getStartDateTime());
        Objects.requireNonNull(appointment.getEndDateTime());
        String key = getKey(appointment.getCalendarId(),
                getYear(appointment.getStartDateTime()),
                getMonth(appointment.getStartDateTime()));
        return key;
    }

    private String getKey(String calendarId, int year, int month){
        String key = calendarId
                + ":" + year
                + ":" + month;
        return key;
    }

    private LocalDate getLocalDate(ZonedDateTime zonedDateTime){
        return zonedDateTime.toLocalDate();
    }

}
