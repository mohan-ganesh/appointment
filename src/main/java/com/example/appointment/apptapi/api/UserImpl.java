package com.example.appointment.apptapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.appointment.apptapi.api.broker.UserBroker;
import com.example.appointment.apptapi.pojo.User;

/**
 * 
 */
@Component
public class UserImpl implements UserApi {

    @Autowired
    UserBroker userBroker;

    /**
     * 
     */
    @Override
    public User getUser(String memberId) {
        User user = userBroker.getUserDetails(memberId);
        if (null == user) {
            user = new User("User not found for " + memberId);
        } else {
            user.setComments("Retrieved the existing user " + memberId);
        }

        return user;
    }

    /**
     * 
     */
    @Override
    public User createUser(User inputUser) {
        User user = userBroker.getUserDetails(inputUser.getMemberId());
        if (null == user) {
            user = userBroker.createUser(inputUser);
            user.setComments("Created new user " + inputUser.getMemberId());
        } else {
            user.setComments("Updated the properties for " + inputUser.getMemberId());
        }
        return user;
    }

}
