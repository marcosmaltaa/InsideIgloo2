package com.insideIgloo.projeto.igloo.Repository;

import com.insideIgloo.projeto.igloo.Entity.SalaConcluidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaConcluidaRepository extends JpaRepository<SalaConcluidaEntity, Long> {
}
