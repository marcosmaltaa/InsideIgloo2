package com.insideIgloo.projeto.igloo.Repository;

import com.insideIgloo.projeto.igloo.Entity.ExpUsuarioEntity;
import com.insideIgloo.projeto.igloo.Entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpUsuarioRepository extends JpaRepository<ExpUsuarioEntity,Long> {
    ExpUsuarioEntity findByIdLogin(LoginEntity idLogin);
}
