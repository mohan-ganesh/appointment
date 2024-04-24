package com.example.appointment.apptapi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.apptapi.api.UserApi;
import com.example.appointment.apptapi.pojo.User;

@RestController
public class UserController {

    public static Log logger = LogFactory.getLog(DefaultController.class);

    @Autowired
    UserApi userApi;

    /**
     *
     * @return String
     */
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity getUserDetails(@PathVariable String memberId) {

        return ResponseEntity.ok(userApi.getUser(memberId));

    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody User userInput) {

        return ResponseEntity.ok(userApi.createUser(userInput));

    }

}