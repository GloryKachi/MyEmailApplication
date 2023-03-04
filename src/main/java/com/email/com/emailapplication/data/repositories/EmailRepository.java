package com.email.com.emailapplication.data.repositories;

import com.email.com.emailapplication.data.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository <Email,Long>{

    Email findByUserName(String userName);

}
