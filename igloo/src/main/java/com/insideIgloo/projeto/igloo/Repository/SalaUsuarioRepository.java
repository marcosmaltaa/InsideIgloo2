package com.insideIgloo.projeto.igloo.Repository;

import com.insideIgloo.projeto.igloo.Entity.ParteSalaEntity;
import com.insideIgloo.projeto.igloo.Entity.SalaUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaUsuarioRepository extends JpaRepository<SalaUsuarioEntity,Long> {
   SalaUsuarioEntity findByIdLoginIdAndIdParteId(Long idLogin, Long idParte);
   List<SalaUsuarioEntity> findByIdLoginIdAndIdParteIdSalaId(Long idLogin, Long idSala);
}
