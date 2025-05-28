package com.autenticacion.fullstack.Dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String correo;
    private String userpassword;
}
