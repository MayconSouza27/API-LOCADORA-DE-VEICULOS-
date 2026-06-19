package org.example.Controller;

import org.example.Model.ChecklistModell;
import org.example.Repository.RepositoryChecklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/checklists")
public class ChecklistController {

    @Autowired
    private RepositoryChecklist repository;

    @PostMapping
    public ResponseEntity<ChecklistModell>
    salvar(@RequestBody ChecklistModell checklist) {
        return new ResponseEntity<>(repository.save(checklist), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ChecklistModell
            >> listarTodos() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChecklistModell>
    buscarPorId(@PathVariable Long id) {
        Optional<ChecklistModell> checklist = repository.findById(id);
        return checklist.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}