package com.example.appointment.apptapi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Base64;

@RestController
public class DefaultController {

    public static Log logger = LogFactory.getLog(DefaultController.class);

    /**
     *
     * @return String
     */
    @RequestMapping(path = "/healthcheck", method = RequestMethod.GET)
    public ResponseEntity<String> healthcheck() {

        return ResponseEntity.ok("alive...");

    }

    /**
     *
     * @param request
     * @return decoded token value
     * @throws JWTDecodeException
     */

    @RequestMapping(path = "/identity", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> identity(HttpServletRequest request) {

        String authInfo = request.getHeader("x-apigateway-api-userinfo");
        byte data[] = Base64.getDecoder().decode(authInfo);
        return ResponseEntity.ok(new String(data));

    }

}