package com.autenticacion.fullstack.Repository;

import com.autenticacion.fullstack.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndPassword(String correo, String password);
}