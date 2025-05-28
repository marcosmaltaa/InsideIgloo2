package com.insideIgloo.projeto.igloo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="TB_EXP_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExpUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "USUARIO_ID", unique = true, nullable = false)
    private LoginEntity idLogin;

    @Column(name = "EXP", nullable = false)
    private Long exp;
}
