package com.example.appointment.pojo;

public class User {

    String memberId;
    String firstName;
    String lastName;
    String email;

    public User(String memberId, String firstName, String lastname, String email) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastname;
        this.email = email;
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

    @Override
    public String toString() {
        return "User [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + "]";
    }

}
