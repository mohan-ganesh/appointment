package com.example.appointment.apptapi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Appointment {

    String id;

    @JsonIgnore
    String userId;
    
    String status;

    public Appointment() {
    }

    public Appointment(String id, String userId, String status) {
        this.id = id;
        this.userId = userId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment [id=" + id + ", userId=" + userId + ", status=" + status + "]";
    }

}
