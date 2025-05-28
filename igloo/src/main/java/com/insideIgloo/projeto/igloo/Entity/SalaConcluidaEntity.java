package com.insideIgloo.projeto.igloo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="TB_SALA_CONCLUIDA")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class SalaConcluidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private LoginEntity idLogin;

    @ManyToOne
    @JoinColumn(name = "SALA_ID")
    private SalaEntity idSala;

    @Column(name = "CONCLUIDO")
    private Boolean concluido;
}
