package org.example.veiculos.service;

import org.example.veiculos.model.VeiculoModel;
import org.example.veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoModel> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<VeiculoModel> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public VeiculoModel salvar(VeiculoModel veiculo) {
        return veiculoRepository.save(veiculo);
    }


    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
}