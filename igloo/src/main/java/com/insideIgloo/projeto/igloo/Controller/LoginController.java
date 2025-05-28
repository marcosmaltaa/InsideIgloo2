package com.insideIgloo.projeto.igloo.Controller;

import com.insideIgloo.projeto.igloo.DTO.LoginDTO;
import com.insideIgloo.projeto.igloo.DTO.UsuarioDTO;
import com.insideIgloo.projeto.igloo.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarLogin(@RequestBody LoginDTO loginDTO) {
        return service.cadastroUsuario(loginDTO);
    }

    @PutMapping(value = "/up")
    public void aumentarExp(@RequestParam(name="user") Long idUsuario,
                            @RequestParam(name="xp")Long xp){
        service.elevarXP(idUsuario, xp);
    }

    @PostMapping(value = "/logar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity logar(@RequestBody UsuarioDTO user){
        return service.loginUsuario(user);
    }
}
