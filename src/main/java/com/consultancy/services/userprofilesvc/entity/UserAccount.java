package com.consultancy.services.userprofilesvc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccount {

    @Id
    private String emailId;
    private String password;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
