package com.insideIgloo.projeto.igloo.Repository;

import com.insideIgloo.projeto.igloo.Entity.ParteSalaEntity;
import com.insideIgloo.projeto.igloo.Entity.SalaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaRepository extends JpaRepository<SalaEntity,Long> {

}
