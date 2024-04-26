package com.example.appointment.apptapi.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentSlot extends Appointment {

    public String startTime;

    public String endTime;

    public Appointment appointments;

    public AppointmentSlot() {
    }

    public AppointmentSlot(String id, String userId, String status, String startTime, String endTime,
            Appointment appointments) {
        super(id, userId, status);
        this.startTime = startTime;
        this.endTime = endTime;
        this.appointments = appointments;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Appointment getAppointments() {
        return appointments;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setAppointments(Appointment appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "AppointmentSlot [startTime=" + startTime + ", endTime=" + endTime + ", appointments=" + appointments
                + "]";
    }
}
