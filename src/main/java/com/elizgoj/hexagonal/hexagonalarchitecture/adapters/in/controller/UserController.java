package com.elizgoj.hexagonal.hexagonalarchitecture.adapters.in.controller;

import com.elizgoj.hexagonal.hexagonalarchitecture.adapters.in.request.UserRequest;
import com.elizgoj.hexagonal.hexagonalarchitecture.domain.entity.User;
import com.elizgoj.hexagonal.hexagonalarchitecture.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @PostMapping("/criarUsuario")
    public ResponseEntity<String> criarUsuario(@RequestBody UserRequest request) {
        if (request == null || request.getUser() == null) {
            return ResponseEntity.badRequest().body("Corpo da requisição inválido ou usuário não informado.");
        }

        User user = request.getUser();

        String erros = UserService.validarUsuario(user);

        if (!erros.isEmpty()) {
            return ResponseEntity.badRequest().body(erros);
        }

        return ResponseEntity.ok("Usuário criado com sucesso!");
    }

}
