package org.example.checklist.service;

import org.example.checklist.model.ChecklistModell;
import org.example.checklist.model.NivelCombustivel;
import org.example.checklist.repository.RepositoryChecklist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService {

    private final RepositoryChecklist repository;

    public ChecklistService(RepositoryChecklist repository) {
        this.repository = repository;
    }

    // 1. Criar ou Atualizar Checklist com Regras de Negócio
    public ChecklistModell salvar(ChecklistModell checklist) {

        // Regra de Negócio 1: Validação do tamanho da placa
        if (checklist.getPlacaVeiculo() == null || checklist.getPlacaVeiculo().trim().length() != 7) {
            throw new IllegalArgumentException("A placa do veículo deve conter exatamente 7 caracteres.");
        }

        // Regra de Negócio 2: Padronizar placa em maiúsculas (ex: abc1d23 -> ABC1D23)
        checklist.setPlacaVeiculo(checklist.getPlacaVeiculo().toUpperCase().trim());

        // Regra de Negócio 3: Alerta de combustível crítico se o tanque estiver vazio
        if (checklist.getNivelCombustivel() == NivelCombustivel.VAZIO) {
            System.out.println("ALERTA: Checklist registrado com veículo no tanque VAZIO!");
        }

        return repository.save(checklist);
    }

    // 2. Listar todos os checklists
    public List<ChecklistModell> listarTodos() {
        return repository.findAll();
    }

    // 3. Buscar checklist por ID com tratamento caso não exista
    public ChecklistModell buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checklist não encontrado para o ID: " + id));
    }

    // 4. Deletar checklist com validação prévia
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Impossível deletar: Checklist não encontrado para o ID: " + id);
        }
        repository.deleteById(id);
    }
}