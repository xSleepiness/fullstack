package com.autenticacion.fullstack.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autenticacion.fullstack.Model.Usuario;
import com.autenticacion.fullstack.Repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String correo, String password) {
        if (correo == null || password == null || correo.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Correo o contraseña vacíos.");
        }

        return usuarioRepository.findByCorreoAndPassword(correo, password)
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
    }
}
