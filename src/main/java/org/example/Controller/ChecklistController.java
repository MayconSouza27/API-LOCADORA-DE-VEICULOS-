package org.example.Controller;
import org.example.Model.ChecklistModel;
import org.example.Service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checklists") // Define a rota base para este controller
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    // 1. Criar um novo Checklist (POST)
    @PostMapping
    public ResponseEntity<ChecklistModel> criarChecklist(@RequestBody ChecklistModel checklist) {
        ChecklistModel novoChecklist = checklistService.salvar(checklist);
        return new ResponseEntity<>(novoChecklist, HttpStatus.CREATED);
    }

    // 2. Listar todos os Checklists (GET)
    @GetMapping
    public ResponseEntity<List<ChecklistModel>> listarTodos() {
        List<ChecklistModel> checklists = checklistService.listarTodos();
        return new ResponseEntity<>(checklists, HttpStatus.OK);
    }

    // 3. Buscar um Checklist por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<ChecklistModel> buscarPorId(@PathVariable Long id) {
        return checklistService.buscarPorId(id)
                .map(checklist -> new ResponseEntity<>(checklist, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 4. Atualizar um Checklist por ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ChecklistModel> atualizar(@PathVariable Long id, @RequestBody ChecklistModel checklist) {
        try {
            ChecklistModel checklistAtualizado = checklistService.atualizar(id, checklist);
            return new ResponseEntity<>(checklistAtualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 5. Deletar um Checklist por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            checklistService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

