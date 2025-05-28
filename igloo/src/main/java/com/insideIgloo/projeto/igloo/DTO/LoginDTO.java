package com.insideIgloo.projeto.igloo.DTO;

import com.insideIgloo.projeto.igloo.Enums.UsuarioEnum;

public record LoginDTO(String email, String nome, String senha, String confirmarSenha, UsuarioEnum tipo) {
}
