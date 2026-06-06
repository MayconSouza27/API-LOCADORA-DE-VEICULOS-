package org.example.Service;
import org.example.Model.ChecklistModel;
import org.example.Repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    // Método para listar todos os checklists
    public List<ChecklistModel> listarTodos() {
        return checklistRepository.findAll();
    }

    // Método para buscar um checklist por ID
    public Optional<ChecklistModel> buscarPorId(Long id) {
        return checklistRepository.findById(id);
    }

    // Método para salvar ou criar um novo checklist
    public ChecklistModel salvar(ChecklistModel checklist) {
        return checklistRepository.save(checklist);
    }

    // Método para atualizar um checklist existente
    public ChecklistModel atualizar(Long id, ChecklistModel checklistAtualizado) {
        return checklistRepository.findById(id).map(checklist -> {
            // OBS: Substitua os métodos "set" abaixo pelos campos reais da sua ChecklistModel
            // exemplo: checklist.setDescricao(checklistAtualizado.getDescricao());
            // checklist.setConcluido(checklistAtualizado.getConcluido());

            return checklistRepository.save(checklist);
        }).orElseThrow(() -> new RuntimeException("Checklist não encontrado com o id: " + id));
    }

    // Método para deletar um checklist
    public void deletar(Long id) {
        if (checklistRepository.existsById(id)) {
            checklistRepository.deleteById(id);
        } else {
            throw new RuntimeException("Checklist não encontrado com o id: " + id);
        }
    }
}


