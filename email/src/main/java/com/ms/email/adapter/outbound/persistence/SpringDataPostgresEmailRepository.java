package com.ms.email.adapter.outbound.persistence;


import com.ms.email.adapter.outbound.persistence.entities.EmailEntity;
import com.ms.email.application.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataPostgresEmailRepository extends JpaRepository<EmailEntity, UUID> {
}
