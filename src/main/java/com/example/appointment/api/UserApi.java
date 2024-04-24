package com.example.appointment.api;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

import com.example.appointment.pojo.User;

public interface UserApi {

    public User getUser(String memberIdString);

    public User createUser(User user);

}
