package com.autenticacion.fullstack.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autenticacion.fullstack.Model.Usuario;
import com.autenticacion.fullstack.Repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String correo, String userpassword) {
        if (correo == null || userpassword == null || correo.isEmpty() || userpassword.isEmpty()) {
            throw new IllegalArgumentException("Correo o contraseña vacíos.");
        }

        return usuarioRepository.findByCorreoAndUserpassword(correo, userpassword)
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
    }
}
