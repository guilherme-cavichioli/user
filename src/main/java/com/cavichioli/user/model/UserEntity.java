package com.cavichioli.user.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {
    private String name;
    private String document;
    private String email;
    private Boolean admin;
}
