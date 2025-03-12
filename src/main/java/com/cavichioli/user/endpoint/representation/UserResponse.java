package com.cavichioli.user.endpoint.representation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String document;
    private String email;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private Boolean admin;
}
