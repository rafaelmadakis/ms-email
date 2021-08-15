package com.ms.email.adapter.outbound.persistence;


import com.ms.email.application.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataPostgresEmailRepository extends JpaRepository<Email, UUID> {
}
