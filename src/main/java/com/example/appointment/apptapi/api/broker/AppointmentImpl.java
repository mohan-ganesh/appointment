package com.example.appointment.apptapi.api.broker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.appointment.apptapi.api.AppointmentApi;
import com.example.appointment.apptapi.pojo.AppointmentSchedule;
import com.example.appointment.apptapi.pojo.AppointmentSlot;
import com.example.appointment.apptapi.pojo.User;

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
    public boolean confirmAppointment(User user, AppointmentSlot appointmentSlot) {

        return appointmentBroker.confirmAppointment(user, appointmentSlot);
    }

}
