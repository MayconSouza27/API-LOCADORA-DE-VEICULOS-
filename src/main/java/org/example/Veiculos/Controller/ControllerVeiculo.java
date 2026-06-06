package org.example.Veiculos.Controller;
import org.example.Veiculos.Entity.VeiculoModel;
import org.example.Veiculos.Service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class ControllerVeiculo {


    @Autowired
    private VeiculoService veiculoService; // Correto: variável com inicial minúscula

    @GetMapping
    public List<VeiculoModel> listar() {
        return veiculoService.listarTodos(); // Em vez de VeiculoService.listarTodos()
    }

    @PostMapping
    public VeiculoModel criar(@RequestBody VeiculoModel veiculo) {
        return VeiculoService.salvar(veiculo);
    }
}

