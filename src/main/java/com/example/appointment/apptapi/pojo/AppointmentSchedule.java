package com.example.appointment.apptapi.pojo;

import java.util.List;

public class AppointmentSchedule extends AppointmentSlot {

    public AppointmentSchedule() {
    }

    public AppointmentSchedule(String id, String userId, String status, String startTime, String endTime,
            Appointment appointments) {
        super(id, userId, status, startTime, endTime, appointments);

    }

    public String date;

    public List<AppointmentSlot> slots;

    public String getDate() {
        return date;
    }

    public List<AppointmentSlot> getSlots() {
        return slots;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSlots(List<AppointmentSlot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "AppointmentSchedule [date=" + date + ", slots=" + slots + "]";
    }

}
