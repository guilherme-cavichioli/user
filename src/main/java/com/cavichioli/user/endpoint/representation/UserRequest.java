package com.cavichioli.user.endpoint.representation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest {
    @NotBlank(message = "Nome do usuário é obrigatório")
    private String name;
    @CPF(message = "CPF informado é inválido.")
    private String document;
    @Email(message = "Email informado é inválido")
    private String email;
    private Boolean admin;
}
