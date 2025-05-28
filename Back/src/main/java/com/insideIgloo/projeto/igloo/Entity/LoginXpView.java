package com.insideIgloo.projeto.igloo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Table(name="VW_USUARIO_XP")
@Getter
@Setter
@NoArgsConstructor
@Immutable
@Entity
public class LoginXpView {

    @Id
    @Column(name = "id_virtual")
    Long id;

    @Column(name = "usuario_id")
    private Long idUsuario;

    @Column(name = "apelido")
    private String apelido;

    @Column(name = "experiencia")
    private Long exp;
}
