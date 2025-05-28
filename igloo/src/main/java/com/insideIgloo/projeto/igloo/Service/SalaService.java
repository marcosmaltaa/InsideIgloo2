package com.insideIgloo.projeto.igloo.Service;

import com.insideIgloo.projeto.igloo.DTO.ListaSalaDTO;
import com.insideIgloo.projeto.igloo.Entity.*;
import com.insideIgloo.projeto.igloo.Repository.ParteSalaRepository;
import com.insideIgloo.projeto.igloo.Repository.SalaConcluidaRepository;
import com.insideIgloo.projeto.igloo.Repository.SalaRepository;
import com.insideIgloo.projeto.igloo.Repository.SalaUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SalaService {

    @Autowired
    private SalaViewService salaViewService;

    @Autowired
    private ParteSalaRepository parteSalaRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private SalaUsuarioRepository salaUsuarioRepository;

    @Autowired
    private SalaConcluidaRepository salaConcluidaRepository;

    @Autowired
    private LoginService loginService;

    public ParteSalaEntity findIdParte(Long ordem, Long idSala){
        return parteSalaRepository.findByIdSala_IdAndOrdem(idSala, ordem);
    }

    public SalaUsuarioEntity findUsuarioParte(LoginEntity login, ParteSalaEntity parte){
        return salaUsuarioRepository.findByIdLoginIdAndIdParteId(login.getId(), parte.getId());
    }

    public List<SalaUsuarioEntity> findParteUsuarios(Long idUsuario, Long idSala){
        return salaUsuarioRepository.findByIdLoginIdAndIdParteIdSalaId(idUsuario, idSala);
    }

    @Transactional
    public Boolean concluirParte(Long idUsuario, Long idSala, Long ordem){
        LoginEntity login = loginService.findUsuario(idUsuario);
        SalaEntity salaAtual = salaRepository.findById(idSala)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada com ID " + idSala));

        ParteSalaEntity parteSala = findIdParte(ordem, idSala);

        if (parteSala == null) {
            throw new RuntimeException("Parte da sala não encontrada para ordem " + ordem + " e sala " + idSala);
        }

        SalaUsuarioEntity sala = findUsuarioParte(login, parteSala);

        if (sala == null) {
            throw new RuntimeException("Relação usuário-parte não encontrada para usuário " + idUsuario + " e parte " + parteSala.getId());
        }

        sala.setConcluida(true);
        salaUsuarioRepository.saveAndFlush(sala);

        List<ListaSalaDTO> salaListDTO = salaViewService.retornaInfoSala(idSala, idUsuario);

        List<ListaSalaDTO> naoConcluidos = salaListDTO.stream()
                .filter(salaDto -> Boolean.FALSE.equals(salaDto.conclusao()))
                .toList();

        if (naoConcluidos.isEmpty()){
            SalaConcluidaEntity salaConcluida = new SalaConcluidaEntity();
            salaConcluida.setIdLogin(login);
            salaConcluida.setIdSala(salaAtual);
            salaConcluida.setConcluido(true);
            salaConcluidaRepository.save(salaConcluida);
            return true;
        }

        return false;

    }

}
