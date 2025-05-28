package com.insideIgloo.projeto.igloo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="TB_PARTE")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ParteSalaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SALA_ID")
    private SalaEntity idSala;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "ORDEM")
    private Long ordem;


}
