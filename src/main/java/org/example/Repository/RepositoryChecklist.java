package org.example.Repository;

import org.example.Model.ChecklistModell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface                                                                                                                                                                                                                     RepositoryChecklist extends JpaRepository<ChecklistModell, Long> {
    // Aqui você já tem acesso a todos os atributos do Model.
    // Se precisar buscar por um atributo específico do Model (ex: placaVeiculo),
    // você cria métodos baseados no nome do atributo:

    java.util.Optional<ChecklistModell> findByPlacaVeiculo(String placaVeiculo);
}