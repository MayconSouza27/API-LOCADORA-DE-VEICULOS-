package org.example.Veiculos.Controller;

import org.example.Veiculos.Entity.VeiculoModel;
import org.example.Veiculos.Service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class ControllerVeiculo {

    @Autowired
    private VeiculoService veiculoService;

    // READ ALL - GET /veiculos
    @GetMapping
    public ResponseEntity<List<VeiculoModel>> listar() {
        List<VeiculoModel> veiculos = veiculoService.listarTodos();
        return ResponseEntity.ok(veiculos);
    }

    // READ ONE - GET /veiculos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<VeiculoModel> buscarPorId(@PathVariable Long id) {
        return veiculoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE - POST /veiculos
    @PostMapping
    public ResponseEntity<VeiculoModel> criar(@RequestBody VeiculoModel veiculo) {
        VeiculoModel novo = veiculoService.salvar(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // UPDATE - PUT /veiculos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<VeiculoModel> atualizar(@PathVariable Long id,
                                                  @RequestBody VeiculoModel veiculo) {
        return veiculoService.buscarPorId(id)
                .map(existente -> {
                    veiculo.setId(id);
                    VeiculoModel atualizado = veiculoService.salvar(veiculo);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }} 

