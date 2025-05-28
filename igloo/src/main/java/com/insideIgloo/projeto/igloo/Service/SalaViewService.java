package com.insideIgloo.projeto.igloo.Service;

import com.insideIgloo.projeto.igloo.DTO.ListaSalaDTO;
import com.insideIgloo.projeto.igloo.DTO.LoginXpDTO;
import com.insideIgloo.projeto.igloo.Entity.LoginXpView;
import com.insideIgloo.projeto.igloo.Entity.SalaUsuarioParteView;
import com.insideIgloo.projeto.igloo.Repository.LoginXpViewRepository;
import com.insideIgloo.projeto.igloo.Repository.SalaUsuarioParteViewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.insideIgloo.projeto.igloo.Specification.SalaUsuarioParteViewSpecs.hasSalaId;
import static com.insideIgloo.projeto.igloo.Specification.SalaUsuarioParteViewSpecs.hasUsuarioId;

@Service
public class SalaViewService {

    @Autowired
    SalaUsuarioParteViewRepository salaUsuarioParteViewRepository;

    @Autowired
    LoginXpViewRepository loginXpViewRepository;

    @Transactional
    public List<ListaSalaDTO> retornaInfoSala(Long idSala, Long idUsuario) {
        List<SalaUsuarioParteView> sala = salaUsuarioParteViewRepository.findAll(
                Specification.where(hasUsuarioId(idUsuario)).and(hasSalaId(idSala))
        );
        return sala.stream()
                .map(ListaSalaDTO::fromEntity)
                .toList();

    }

    @Transactional
    public List<LoginXpDTO> topDez(){
    List<LoginXpView> top10entity =  loginXpViewRepository.findTop10ByOrderByExpDesc();

        return top10entity.stream()
                .map(LoginXpDTO::fromEntity)
                .toList();
    }
}
