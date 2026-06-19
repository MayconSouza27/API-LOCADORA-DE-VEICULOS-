package org.example.Veiculos.Repository;

import org.example.Veiculos.Entity.VeiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<VeiculoModel, Long> {

    // Buscar por placa (única)
    Optional<VeiculoModel> findByPlaca(String placa);

    // Buscar por marca
    List<VeiculoModel> findByMarca(String marca);

    // Buscar por modelo
    List<VeiculoModel> findByModelo(String modelo);

    // Buscar apenas veículos ativos
    List<VeiculoModel> findByAtivo(Boolean ativo);

    // Buscar por marca e modelo
    List<VeiculoModel> findByMarcaAndModelo(String marca, String modelo);
}