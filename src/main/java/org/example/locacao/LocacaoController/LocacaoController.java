package org.example.locacao.LocacaoController;

import org.example.locacao.model.LocacaoModel;
import org.example.locacao.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @GetMapping
    public List<LocacaoModel> listarTodas() {
        return locacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocacaoModel> buscarPorId(@PathVariable Long id) {
        return locacaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LocacaoModel> criar(@RequestBody LocacaoModel locacao) {
        LocacaoModel novaLocacao = locacaoRepository.save(locacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaLocacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!locacaoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        locacaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}