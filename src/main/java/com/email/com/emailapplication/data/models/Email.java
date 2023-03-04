package com.email.com.emailapplication.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    @OneToOne
    @JoinColumn(referencedColumnName = "date")
    private EDate dateOfBirth;
    private Gender gender;
    private String city;
    private String userName;
    private String password;
    private int age;
    private Year currentYear=Year.now();

    public int getAge(){
      int bAge = Integer.parseInt( getDateOfBirth().getYear());
      String presentYear = String.valueOf(getCurrentYear());
      int year = Integer.parseInt(presentYear);
       return  age = year - bAge;
    }

}
