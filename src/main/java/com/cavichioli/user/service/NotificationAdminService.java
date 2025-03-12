package com.cavichioli.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationAdminService {

    @Value("${notification.admin.email:}")
    private String adminEmail;

    public void sendAdminNotification(String userEmail) {
        log.info("[Notify User Created] - Um novo usuário com o seguinte email {}, foi criado " +
                "como administrador, enviado para: {}", userEmail, adminEmail);
        //@TODO enviar email
    }
}
