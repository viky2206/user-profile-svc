package com.consultancy.services.userprofilesvc.model;

import lombok.Data;

@Data
public class CreateAccountRequest {

    private String emailId;
    private String password;

}
