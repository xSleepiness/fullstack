package com.autenticacion.fullstack.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autenticacion.fullstack.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndUserpassword(String correo, String userpassword);
}