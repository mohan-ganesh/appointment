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
import org.springframework.http.*;

@RestController
public class UserController {

    public static Log logger = LogFactory.getLog(DefaultController.class);

    @Autowired
    UserApi userApi;

    /**
     *
     * @return String
     */
    @RequestMapping(path = "/user/{memberId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserDetails(@PathVariable String memberId) {

        return ResponseEntity.ok(userApi.getUser(memberId));

    }

    @RequestMapping(path = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User userInput) {
        
        logger.info("createUser() - " + userInput.toString());
        return ResponseEntity.ok(userApi.createUser(userInput));

    }

}