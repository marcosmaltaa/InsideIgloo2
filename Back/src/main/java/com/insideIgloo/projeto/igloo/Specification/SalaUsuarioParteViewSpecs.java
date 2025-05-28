package com.insideIgloo.projeto.igloo.Specification;

import com.insideIgloo.projeto.igloo.Entity.SalaUsuarioParteView;
import org.springframework.data.jpa.domain.Specification;

public class SalaUsuarioParteViewSpecs {
    public static Specification<SalaUsuarioParteView> hasUsuarioId(Long idUsuario) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("idUsuario"), idUsuario);
        };
    }

    public static Specification<SalaUsuarioParteView> hasSalaId(Long idSala) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("idSala"), idSala);
        };
    }
}
