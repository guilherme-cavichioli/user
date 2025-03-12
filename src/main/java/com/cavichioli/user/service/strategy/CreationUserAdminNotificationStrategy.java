package com.cavichioli.user.service.strategy;

import com.cavichioli.user.model.UserEntity;
import com.cavichioli.user.service.NotificationAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CreationUserAdminNotificationStrategy implements CreationUserNotificationStrategy{

    private final NotificationAdminService notificationAdminService;

    @Override
    public Boolean canHandle(Boolean isAdmin) {
        return Boolean.TRUE.equals(isAdmin);
    }

    @Override
    public void sendCreationNotification(UserEntity userEntity) {
        notificationAdminService.sendAdminNotification(userEntity.getEmail());

    }
}
