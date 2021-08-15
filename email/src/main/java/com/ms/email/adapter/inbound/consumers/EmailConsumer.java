package com.ms.email.adapter.inbound.consumers;

import com.ms.email.adapter.inbound.dto.EmailDTO;
import com.ms.email.application.entities.Email;
import com.ms.email.application.ports.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTO emailDTO) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);
        emailService.sendEmail(email);
        System.out.println("email Status " + email.getStatusEmail().toString());
    }
}