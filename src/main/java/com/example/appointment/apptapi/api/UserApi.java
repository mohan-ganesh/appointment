package com.example.appointment.apptapi.api;

import com.example.appointment.apptapi.pojo.User;

public interface UserApi {

    public User getUser(String memberIdString);

    public User createUser(User user);

}
