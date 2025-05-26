package com.autenticacion.fullstack.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CORREO", nullable = false, unique = true)
    private String correo;

    @Column(name = "PASSWORD", nullable = false)
    private String password;
}