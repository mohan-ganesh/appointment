package com.example.appointment.apptapi.api.broker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.apptapi.config.FirestoreConfig;
import com.example.appointment.apptapi.exception.BrokerException;
import com.example.appointment.apptapi.pojo.User;

import java.util.concurrent.ExecutionException;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

@Service
public class UserBroker {

    private final Log logger = LogFactory.getLog(UserBroker.class);

    @Autowired
    FirestoreConfig firestore;

    /**
     * 
     */
    public User getUserDetails(String memberId) {
        User user = null;
        String nodePath = "users";
        try {

            ApiFuture<QuerySnapshot> querySnapshotApiFuture = firestore.getConnection().collection(nodePath)
                    .whereEqualTo(BrokerConstants.memberId, memberId).get();

            if (!querySnapshotApiFuture.get().isEmpty()) {
                for (DocumentSnapshot documentSnapshot : querySnapshotApiFuture.get().getDocuments()) {
                    user = documentSnapshot.toObject(User.class);
                }

            }

        } catch (InterruptedException | ExecutionException e) {
            throw new BrokerException("getUserDetails", e);
        }

        return user;
    }

    /**
     * 
     */
    public User createUser(User user) {

        user = null;

        return user;

    }

}
