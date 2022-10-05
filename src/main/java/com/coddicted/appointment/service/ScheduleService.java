package com.coddicted.appointment.service;

import com.coddicted.appointment.model.Schedule;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getSchedules(Pageable paging);
    Schedule getSchedule(String scheduleId);
    Schedule saveSchedule(Schedule schedule);
}
