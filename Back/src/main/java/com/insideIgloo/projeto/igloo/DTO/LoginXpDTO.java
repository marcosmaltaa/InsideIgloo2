package com.insideIgloo.projeto.igloo.DTO;

import com.insideIgloo.projeto.igloo.Entity.LoginXpView;
import com.insideIgloo.projeto.igloo.Entity.SalaUsuarioParteView;

public record LoginXpDTO(Long idUsuario, String nomeUsuario, Long xp) {

    public static LoginXpDTO fromEntity(LoginXpView entity) {
        return new LoginXpDTO(
                entity.getIdUsuario(),
                entity.getApelido(),
                entity.getExp()
        );
    }
}
