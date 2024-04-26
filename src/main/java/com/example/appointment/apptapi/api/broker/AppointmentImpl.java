package com.example.appointment.apptapi.api.broker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.appointment.apptapi.api.AppointmentApi;
import com.example.appointment.apptapi.pojo.AppointmentRequest;
import com.example.appointment.apptapi.pojo.AppointmentSchedule;
import com.example.appointment.apptapi.pojo.AppointmentSlot;
import com.example.appointment.apptapi.pojo.User;
import com.google.cloud.firestore.DocumentReference;

@Component
public class AppointmentImpl implements AppointmentApi {

    @Autowired
    AppointmentBroker appointmentBroker;

    @Override
    public boolean createAppointmentSlots(AppointmentSchedule appointmentSchedule) {

        return appointmentBroker.createAppointmentSlots(appointmentSchedule);
    }

    @Override
    public List<AppointmentSchedule> getAppointmentSlots() {

        return appointmentBroker.getAppointmentSlots();
    }

    @Override
    public AppointmentRequest confirmAppointment(AppointmentRequest appointmentRequest) {

        return appointmentBroker.confirmAppointment(appointmentRequest);
    }

}
