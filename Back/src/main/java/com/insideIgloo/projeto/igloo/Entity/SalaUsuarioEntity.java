package com.insideIgloo.projeto.igloo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="TB_USUARIO_PARTE")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class SalaUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private LoginEntity idLogin;

    @ManyToOne
    @JoinColumn(name = "PARTE_ID")
    private ParteSalaEntity idParte;

    @Column(name = "CONCLUIDA")
    private Boolean concluida;

}
