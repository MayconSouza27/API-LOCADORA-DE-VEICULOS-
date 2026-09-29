package org.example.locacao.repository;

import org.example.locacao.model.LocacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<LocacaoModel, Long> {
}