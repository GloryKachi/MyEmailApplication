package com.email.com.emailapplication.services;

import com.email.com.emailapplication.EmailException;
import com.email.com.emailapplication.data.models.Email;
import com.email.com.emailapplication.data.repositories.EmailRepository;
import com.email.com.emailapplication.dtos.requests.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    static
    EmailRepository emailRepository;

    @Override
    public String createAccount(EmailRequest emailRequest) throws EmailException {
        String verifiedPassword = verifyPassword(emailRequest.getPassword());
        String verifyUserPhoneNumber = verifyValueOfPhoneNumber(emailRequest.getPhoneNumber());
        Email email = Email.builder().firstName(emailRequest.getFirstName())
                .lastName(emailRequest.getLastName())
                .userName(emailRequest.getUserName())
                .city(emailRequest.getCity())
                .password(verifiedPassword)
                .gender(emailRequest.getGender())
                .phoneNumber(verifyUserPhoneNumber).build();

        return null;
    }

    public String verifyPassword(String password) throws EmailException {
        if (password.length() != 10) throw new EmailException("Password must be 10 characters long");
        if (!verifyPasswordLetters(password)) throw new EmailException("Password must contain letters");
        if (!verifyPasswordDigits(password)) throw new EmailException("Password must contain digits");
        return password;
    }

    public String verifyValueOfPhoneNumber(String phoneNumber) throws EmailException {
        if (!verifyPhoneNumber(phoneNumber)) throw new EmailException("Input value in digits");
        if (!verifyPhoneNumbersLength(phoneNumber)) throw new EmailException("Numbers must be eleven");
        return phoneNumber;
    }

    public boolean verifyPasswordLetters(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLetter(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyPasswordDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

//    public boolean verifyPasswordSymbols(String password){
//        for (int i = 0; i < password.length(); i++) {
//            if (Character.OTHER_SYMBOL(password.charAt(i)))
//        }
//    }

    public boolean verifyPhoneNumber(String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (Character.isAlphabetic(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyPhoneNumbersLength(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            return false;
        }
        return true;
    }

    public boolean findByUserName(String userName){
        Email email = emailRepository.findByUserName(userName);
        if (email != null) return true;
        return false;
    }

    public String suggestUserName(String userName){
        Random random = new Random();
        int suggest = random.nextInt(100)+1;
        if (findByUserName(userName)) {
            String concatenate = String.valueOf(suggest);
            return userName + concatenate;
        }
        return userName;
    }

}
