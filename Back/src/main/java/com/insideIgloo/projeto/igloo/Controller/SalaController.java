package com.insideIgloo.projeto.igloo.Controller;

import com.insideIgloo.projeto.igloo.DTO.ListaSalaDTO;
import com.insideIgloo.projeto.igloo.DTO.LoginDTO;
import com.insideIgloo.projeto.igloo.DTO.LoginXpDTO;
import com.insideIgloo.projeto.igloo.Service.SalaService;
import com.insideIgloo.projeto.igloo.Service.SalaViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService service;

    @Autowired
    private SalaViewService serviceView;

    @PutMapping(value = "/concluir", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean concluirPagina(@RequestParam(name="user") Long idUsuario,
                               @RequestParam(name="room") Long idSala,
                               @RequestParam(name="pag") Long pagina) {
        return service.concluirParte(idUsuario, idSala, pagina);
    }

    @GetMapping(value = "/situacaoSala", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListaSalaDTO> situacaoSala(@RequestParam(name="user") Long idUsuario,
                                           @RequestParam(name="room") Long idSala)
    {
        return serviceView.retornaInfoSala(idSala, idUsuario);
    }

    @GetMapping(value = "/top10", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LoginXpDTO>retornaTopDez(){
        return serviceView.topDez();
    }

}
