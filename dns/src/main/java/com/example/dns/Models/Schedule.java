package com.example.dns.Models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class Schedule {

    private Long idTimetable;
    @NotNull
    @NotBlank(message = "Schedule is required")
    private String schedule;

    public Schedule() {
    }

    public Schedule(Long idTimetable, String schedule) {
        this.idTimetable = idTimetable;
        this.schedule = schedule;
    }

    public Long getIdTimetable() {
        return idTimetable;
    }

    public void setIdTimetable(Long idTimetable) {
        this.idTimetable = idTimetable;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
