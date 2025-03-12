package com.cavichioli.user.service.strategy;

import com.cavichioli.user.model.UserEntity;
import com.cavichioli.user.service.NotificationUserDefaultService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CreationUserDefaultNotificationStrategy implements CreationUserNotificationStrategy{

    private final NotificationUserDefaultService notificationUserDefaultService;

    @Override
    public Boolean canHandle(Boolean isAdmin) {
        return Boolean.FALSE.equals(isAdmin);
    }

    @Override
    public void sendCreationNotification(UserEntity userEntity) {
        notificationUserDefaultService.sendNotification(userEntity.getEmail());

    }
}
