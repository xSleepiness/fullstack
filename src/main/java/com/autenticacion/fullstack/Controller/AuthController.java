
package com.autenticacion.fullstack.Controller;

import com.autenticacion.fullstack.Dto.LoginRequest;
import com.autenticacion.fullstack.Model.Usuario;
import com.autenticacion.fullstack.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")

public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Usuario usuario = authService.autenticar(
                    loginRequest.getCorreo(), loginRequest.getPassword());

            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "¡Inicio de sesión logrado!");
            response.put("usuarioId", usuario.getId());

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Error interno del servidor"));
        }
    }
    
}