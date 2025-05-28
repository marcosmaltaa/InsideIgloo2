package com.insideIgloo.projeto.igloo.Service;

import com.insideIgloo.projeto.igloo.DTO.LoginDTO;
import com.insideIgloo.projeto.igloo.DTO.LoginResponseDTO;
import com.insideIgloo.projeto.igloo.DTO.UsuarioDTO;
import com.insideIgloo.projeto.igloo.Entity.ExpUsuarioEntity;
import com.insideIgloo.projeto.igloo.Entity.LoginEntity;
import com.insideIgloo.projeto.igloo.Entity.SalaUsuarioEntity;
import com.insideIgloo.projeto.igloo.Enums.UsuarioEnum;
import com.insideIgloo.projeto.igloo.Infra.Security.TokenService;
import com.insideIgloo.projeto.igloo.Repository.ExpUsuarioRepository;
import com.insideIgloo.projeto.igloo.Repository.LoginRepository;
import com.insideIgloo.projeto.igloo.Repository.ParteSalaRepository;
import com.insideIgloo.projeto.igloo.Repository.SalaUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;

    @Autowired
    private ParteSalaRepository parteSalaRepository;

    @Autowired
    private SalaUsuarioRepository salaUsuarioRepository;

    @Autowired
    private ExpUsuarioRepository expUsuarioRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Transactional
    public ResponseEntity<?> loginUsuario(UsuarioDTO data){
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            LoginEntity login = repository.findByEmail(data.email());
            var token = tokenService.generateToken((LoginEntity) auth.getPrincipal());

            return ResponseEntity.ok(new LoginResponseDTO(login.getNome(),token));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Email ou senha incorretos.");
        }
    }

    @Transactional
    public ResponseEntity cadastroUsuario(LoginDTO data){

        if(repository.findByEmail(data.email()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        // Criação do usuário
        LoginEntity login = new LoginEntity();
        login.setNome(data.nome());
        login.setEmail(data.email());
        login.setSenha(encryptedPassword);
        login.setTipo(UsuarioEnum.USUARIO);
        LoginEntity loginFeito = repository.save(login);

        ExpUsuarioEntity expUsuario = new ExpUsuarioEntity();
        expUsuario.setExp(0L);
        expUsuario.setIdLogin(loginFeito);
        expUsuarioRepository.save(expUsuario);

        // Após salvar o usuário, cria as ligações com todas as partes existentes
        parteSalaRepository.findAll().forEach(parte -> {
            SalaUsuarioEntity salaUsuario = new SalaUsuarioEntity();
            salaUsuario.setIdLogin(login);
            salaUsuario.setIdParte(parte);
            salaUsuario.setConcluida(false);
            salaUsuarioRepository.save(salaUsuario);
        });

        return ResponseEntity.ok().build();
    }

    public LoginEntity findUsuario(Long id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void elevarXP(Long idUsuario, Long xp){
        LoginEntity usuario = repository.findById(idUsuario).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        ExpUsuarioEntity expUsuario = expUsuarioRepository.findByIdLogin(usuario);

        Long exp = expUsuario.getExp() + xp;
        expUsuario.setExp(exp);

        expUsuarioRepository.save(expUsuario);


    }
}
