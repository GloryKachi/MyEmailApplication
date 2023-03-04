package com.email.com.emailapplication.services;

import com.email.com.emailapplication.EmailException;
import com.email.com.emailapplication.data.models.Gender;
import com.email.com.emailapplication.dtos.requests.EmailRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceImplTest {
    EmailRequest emailRequest;
    private EmailService emailService;
    @Autowired
    public EmailServiceImplTest(EmailService emailService) {
        this.emailService = emailService;
    }

    @BeforeEach
    void setUp() {
        emailRequest = new EmailRequest();
        emailRequest.setFirstName("Titilayo");
        emailRequest.setLastName("Abiodun");
        emailRequest.setPhoneNumber("08160430491");
        emailRequest.setCity("Lagos");
        emailRequest.setGender(Gender.FEMALE);
        emailRequest.setPassword("1122334455");
        emailRequest.setUserName("TAbiodun");
    }
    @Test
    public void testThatUsersCanRegister() throws EmailException {
        emailService.createAccount(emailRequest);

        }



}