package com.example.api_yp.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
