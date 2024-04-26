package com.example.appointment.apptapi.api;

import java.util.List;

import com.example.appointment.apptapi.pojo.AppointmentSchedule;
import com.example.appointment.apptapi.pojo.AppointmentSlot;
import com.example.appointment.apptapi.pojo.AppointmentRequest;
import com.google.cloud.firestore.DocumentReference;

public interface AppointmentApi {

    public boolean createAppointmentSlots(AppointmentSchedule appointmentSchedule);

    public List<AppointmentSchedule> getAppointmentSlots();

    public AppointmentRequest confirmAppointment(AppointmentRequest appointmentRequest);
}
