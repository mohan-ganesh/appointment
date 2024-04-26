package com.example.appointment.apptapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.apptapi.api.AppointmentApi;
import com.example.appointment.apptapi.api.UserApi;
import com.example.appointment.apptapi.pojo.AppointmentSchedule;
import com.example.appointment.apptapi.pojo.AppointmentSlot;
import com.example.appointment.apptapi.pojo.User;
import org.springframework.http.*;

@RestController
public class AppointmentController {

    public static Log logger = LogFactory.getLog(AppointmentController.class);

    @Autowired
    AppointmentApi appointmentApi;

    /**
     *
     * @return String
     */
    @RequestMapping(path = "/dayandtime", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AppointmentSchedule>> getAppointmentSlots() {

        return ResponseEntity.ok(appointmentApi.getAppointmentSlots());

    }

    @RequestMapping(path = "/confirm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createAppointment(@RequestBody User user,
            @RequestBody AppointmentSlot appointmentSlot) {

        appointmentApi.confirmAppointment(user, appointmentSlot);

        return ResponseEntity.ok("create appointment.");

    }

}