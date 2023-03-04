package com.email.com.emailapplication.services;

import com.email.com.emailapplication.EmailException;
import com.email.com.emailapplication.dtos.requests.EmailRequest;

public interface EmailService {
    String createAccount(EmailRequest emailRequest) throws EmailException;
}
