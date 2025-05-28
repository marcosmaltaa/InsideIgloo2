package com.insideIgloo.projeto.igloo.Repository;

import com.insideIgloo.projeto.igloo.Entity.ParteSalaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParteSalaRepository extends JpaRepository<ParteSalaEntity,Long> {
    ParteSalaEntity findByIdSala_IdAndOrdem(Long idSala, Long ordem);

}
