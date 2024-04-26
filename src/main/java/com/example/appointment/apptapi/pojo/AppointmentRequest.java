package com.example.appointment.apptapi.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentRequest {
    public String memberId;
    public String firstName;
    public String lastName;
    public String email;
    public String appointmentId;
    public String comments;

    public AppointmentRequest() {
    }

    public AppointmentRequest(String memberId, String firstName, String lastName, String email, String appointmentId) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.appointmentId = appointmentId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "AppointmentRequest [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + ", appointmentId=" + appointmentId + ", comments=" + comments + "]";
    }
}
