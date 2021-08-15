package com.ms.email.application.ports;

import com.ms.email.application.entities.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EmailService {


    Email sendEmail(Email email);
    Page<Email> findAll(Pageable pageable);
    Optional<Email> findById(UUID emailId);
}
