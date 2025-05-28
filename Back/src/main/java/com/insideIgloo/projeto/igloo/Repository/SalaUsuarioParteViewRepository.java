package com.insideIgloo.projeto.igloo.Repository;

import com.insideIgloo.projeto.igloo.Entity.SalaUsuarioParteView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaUsuarioParteViewRepository extends
        JpaRepository<SalaUsuarioParteView, Long>,
        JpaSpecificationExecutor<SalaUsuarioParteView> {
}
