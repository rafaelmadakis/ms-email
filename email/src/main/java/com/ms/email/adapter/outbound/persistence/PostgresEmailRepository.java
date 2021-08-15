package com.ms.email.adapter.outbound.persistence;

import com.ms.email.adapter.outbound.persistence.SpringDataPostgresEmailRepository;
import com.ms.email.application.entities.Email;
import com.ms.email.application.ports.EmailRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class PostgresEmailRepository implements EmailRepository {

    private final SpringDataPostgresEmailRepository emailRepository;

    public PostgresEmailRepository(final SpringDataPostgresEmailRepository orderRepository) {
        this.emailRepository = orderRepository;
    }

    @Override
    public Email save(Email emailModel) {
        return emailRepository.save(emailModel);
    }



    @Override
    public Page<Email> findAll(Pageable pageable) {
        return emailRepository.findAll(pageable);
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        return emailRepository.findById(emailId);
    }
}