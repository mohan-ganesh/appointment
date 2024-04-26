package com.example.appointment.apptapi.api;

import java.util.List;

import com.example.appointment.apptapi.pojo.AppointmentSchedule;
import com.example.appointment.apptapi.pojo.AppointmentSlot;
import com.example.appointment.apptapi.pojo.User;

public interface AppointmentApi {

    public boolean createAppointmentSlots(AppointmentSchedule appointmentSchedule);

    public List<AppointmentSchedule> getAppointmentSlots();

    public boolean confirmAppointment(User user, AppointmentSlot appointmentSlot);
}
