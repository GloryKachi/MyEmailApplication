package com.email.com.emailapplication.dtos.requests;

import com.email.com.emailapplication.data.models.Gender;
import lombok.Data;

@Data
public class EmailRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Gender gender;
    private String city;
    private String userName;
    private String password;
}
