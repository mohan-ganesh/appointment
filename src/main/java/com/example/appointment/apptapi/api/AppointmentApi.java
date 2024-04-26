package com.example.appointment.apptapi.api;

import java.util.List;

import com.example.appointment.apptapi.pojo.AppointmentSchedule;

public interface AppointmentApi {

    public boolean createAppointmentSlots(AppointmentSchedule appointmentSchedule);

    public List<AppointmentSchedule> getAppointmentSlots();

    public boolean confirmAppointment();
}
