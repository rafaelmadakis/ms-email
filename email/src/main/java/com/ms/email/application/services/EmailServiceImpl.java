package com.ms.email.application.services;

import com.ms.email.application.entities.Email;
import com.ms.email.application.entities.enums.StatusEmail;
import com.ms.email.application.ports.EmailService;
import com.ms.email.application.ports.EmailRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;

    private final JavaMailSender emailSender;

    public EmailServiceImpl(final EmailRepository emailRepository, final JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    @Override
    public Email sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e){
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(email);
        }
    }

    @Override
    public Page<Email> findAll(Pageable pageable) {
        //inserir manipulação de dados/regras
        return  emailRepository.findAll(pageable);
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        //inserir manipulação de dados/regras
        return emailRepository.findById(emailId);
    }
}