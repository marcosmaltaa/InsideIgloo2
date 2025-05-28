package com.insideIgloo.projeto.igloo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Table(name="vw_sala_usuario_parte")
@Getter
@Setter
@NoArgsConstructor
@Immutable
@Entity
public class SalaUsuarioParteView {

    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "id_sala")
    private Long idSala;

    @Column(name = "nome_sala")
    private String nomeSala;

    @Column(name = "ordem_parte")
    private Long ordemParte;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "concluido")
    private Boolean concluido;
}
