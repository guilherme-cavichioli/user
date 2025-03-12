package com.cavichioli.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationUserDefaultService {

    public void sendNotification(String userEmail) {
        log.info("[Notify User Created] - Novo usuário {}, criado com sucesso", userEmail);
        //@TODO enviar email
    }
}
