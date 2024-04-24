package com.example.appointment.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.appointment.api.broker.UserBroker;
import com.example.appointment.pojo.User;

@Component
public class UserImpl implements UserApi {

    @Autowired
    UserBroker userBroker;

    /**
     * 
     */
    @Override
    public User getUser(String memberId) {
        return userBroker.getUserDetails(memberId);
    }

    /**
     * 
     */
    @Override
    public User createUser(User inputUser) {
        User user = userBroker.getUserDetails(inputUser.getMemberId());
        if (null == user) {
            user = userBroker.createUser(inputUser);
        }
        return user;
    }

}
