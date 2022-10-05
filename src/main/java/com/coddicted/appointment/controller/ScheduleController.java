package com.coddicted.appointment.controller;

import com.coddicted.appointment.model.Schedule;
import com.coddicted.appointment.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ScheduleController {
    private ScheduleService scheduleService;

    @GetMapping
    public List<Schedule> getSchedules(@RequestParam(defaultValue = "0", name="page") int page,
                                       @RequestParam(defaultValue = "10", name="size") int size){
        Pageable paging = PageRequest.of(page, size);
        return this.scheduleService.getSchedules(paging);
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable("id") String id){
        return this.scheduleService.getSchedule(id);
    }

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule){
        return this.scheduleService.saveSchedule(schedule);
    }
}
