package org.example.Veiculos.Repository;

import org.example.Veiculos.Entity.VeiculoModel;

import java.util.List;

public interface VeiculoRepository {
    static VeiculoModel save(VeiculoModel veiculo) {
        return null;
    }

    static List<VeiculoModel> findAll() {
        return List.of();
    }
}

