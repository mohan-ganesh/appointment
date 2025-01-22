package com.example.appointment.apptapi.api.broker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.apptapi.config.FirestoreConfig;
import com.example.appointment.apptapi.pojo.AppointmentRequest;
import com.example.appointment.apptapi.pojo.AppointmentSchedule;
import com.example.appointment.apptapi.pojo.AppointmentSlot;
import com.example.appointment.apptapi.config.FirestoreConfig;
import com.example.appointment.apptapi.exception.BrokerException;
import com.example.appointment.apptapi.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.CollectionReference;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

@Service
public class AppointmentBroker {

    private final Log logger = LogFactory.getLog(AppointmentBroker.class);

    @Autowired
    FirestoreConfig firestore;

    public boolean createAppointmentSlots(AppointmentSchedule appointmentSchedule) {

        String nodePath = "appointments";
        ApiFuture<WriteResult> documentReference = firestore.getConnection().collection(nodePath)
                .document(appointmentSchedule.getId()).create(appointmentSchedule);
        logger.info(documentReference.toString());
        return true;

    }

    public List<AppointmentSchedule> getAppointmentSlots() {

        String nodePath = "appointments";

        CollectionReference collection = firestore.getConnection().collection(nodePath);
        List<AppointmentSchedule> listAppointmentSchedule = new ArrayList();
        try {
            QuerySnapshot querysnapShot = collection.get().get();
            for (DocumentSnapshot documentSnapshot : querysnapShot.getDocuments()) {
                listAppointmentSchedule.add(documentSnapshot.toObject(AppointmentSchedule.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new BrokerException(e.getMessage());
        }

        return listAppointmentSchedule;
    }

    public AppointmentRequest confirmAppointment(AppointmentRequest appointmentRequest) {

        DocumentReference docRef = null;
        try {

            ApiFuture<DocumentReference> result = firestore.getConnection().collection("confirm")
                    .add(appointmentRequest);
            docRef = result.get();

            docRef.getId();

            Random random = new Random();
            // Generate the first four digits
            int firstPart = random.nextInt(10000);

            // Generate the last four digits
            int secondPart = random.nextInt(10000);

            // Format the output
            String formattedNumber = String.format("%04d-%04d", firstPart, secondPart);

            appointmentRequest
                    .setComments("Appointment is created for " + appointmentRequest.getFirstName() + " "
                            + appointmentRequest.getLastName() + " and here is your confirmation code :  "
                            + formattedNumber);

        } catch (InterruptedException | ExecutionException e) {
            throw new BrokerException(e.getMessage());
        }

        return appointmentRequest;
    }

}
