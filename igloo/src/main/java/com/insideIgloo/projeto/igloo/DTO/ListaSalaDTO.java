package com.insideIgloo.projeto.igloo.DTO;

import com.insideIgloo.projeto.igloo.Entity.ParteSalaEntity;
import com.insideIgloo.projeto.igloo.Entity.SalaUsuarioEntity;
import com.insideIgloo.projeto.igloo.Entity.SalaUsuarioParteView;

public record ListaSalaDTO(Long idSala, Long idUsuario, Boolean conclusao, Long ordem, String nome) {

    public static ListaSalaDTO fromEntity(SalaUsuarioParteView entity) {
        return new ListaSalaDTO(
                entity.getIdSala(),
                entity.getIdUsuario(),
                entity.getConcluido(),
                entity.getOrdemParte(),
                entity.getNomeSala()
        );
    }


}
