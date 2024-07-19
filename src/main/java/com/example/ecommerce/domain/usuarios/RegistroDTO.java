package com.example.ecommerce.domain.usuarios;

public record RegistroDTO(String nome, String sobrenome, String email, String senha, UsuarioRole role) {
}
