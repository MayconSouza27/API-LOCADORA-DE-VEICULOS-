package org.example.Repository;

import org.example.Model.ChecklistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistRepository extends JpaRepository<ChecklistModel, Long> {
    // Você pode adicionar métodos personalizados de busca aqui, se precisar.
    // Exemplo: List<ChecklistModel> findByPlacaVeiculo(String placaVeiculo);
}