package org.example.Veiculos.Repository;


import org.example.Model.ChecklistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistRepository extends JpaRepository<ChecklistModel, Long> {
    // O Spring Data JPA implementa automaticamente todos os métodos CRUD aqui.
}
