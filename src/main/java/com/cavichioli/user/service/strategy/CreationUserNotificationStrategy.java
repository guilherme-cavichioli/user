package com.cavichioli.user.service.strategy;

import com.cavichioli.user.model.UserEntity;

public interface CreationUserNotificationStrategy {
    Boolean canHandle(Boolean isAdmin);

    void sendCreationNotification(UserEntity userEntity);
}
