package com.coddicted.appointment.service.impl;

import com.coddicted.appointment.model.Schedule;
import com.coddicted.appointment.repository.ScheduleRepository;
import com.coddicted.appointment.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> getSchedules(Pageable paging) {
        return scheduleRepository.findAll(paging).toList();
    }

    @Override
    public Schedule getSchedule(String scheduleId) {
        Optional<Schedule> res = scheduleRepository.findById(scheduleId);
        if(res.isPresent())
            return res.get();
        return null;
    }

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
}
