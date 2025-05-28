package com.insideIgloo.projeto.igloo.Repository;

import com.insideIgloo.projeto.igloo.Entity.LoginXpView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginXpViewRepository extends JpaRepository<LoginXpView, Long> {
    List<LoginXpView> findTop10ByOrderByExpDesc();
}
