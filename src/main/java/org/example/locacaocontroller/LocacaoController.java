package org.example.locacaocontroller;

import org.example.locacao.model.LocacaoModel;
import org.example.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @GetMapping
    public List<LocacaoModel> listarTodas() {
        return locacaoService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocacaoModel> buscarPorId(@PathVariable Long id) {
        return locacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LocacaoModel> criar(@RequestBody LocacaoModel locacao) {
        LocacaoModel novaLocacao = locacaoService.salvar(locacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaLocacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocacaoModel> atualizar(@PathVariable Long id, @RequestBody LocacaoModel locacao) {
        return locacaoService.buscarPorId(id)
                .map(existente -> {
                    locacao.setId(id);
                    LocacaoModel atualizado = locacaoService.salvar(locacao);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (locacaoService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        locacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}