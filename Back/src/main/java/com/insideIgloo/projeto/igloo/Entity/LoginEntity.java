package com.insideIgloo.projeto.igloo.Entity;


import com.insideIgloo.projeto.igloo.Enums.UsuarioEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Table(name="TB_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class LoginEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "APELIDO")
    private String nome;

    @Column(name= "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO")
    private UsuarioEnum tipo;

    @OneToOne(mappedBy = "idLogin", cascade = CascadeType.ALL, orphanRemoval = true)
    private ExpUsuarioEntity expUsuario;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.tipo == UsuarioEnum.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
