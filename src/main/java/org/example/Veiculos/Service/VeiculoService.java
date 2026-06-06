package org.example.Veiculos.Service;

import org.example.Veiculos.Entity.VeiculoModel;
import org.example.Veiculos.Repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VeiculoService {

    // 1. REMOVIDO O 'static' DAQUI
    @Autowired
    private VeiculoRepository veiculoRepository;

    // 2. Método listarTodos descomentado e sem static
    public List<VeiculoModel> listarTodos() {
        return VeiculoRepository.findAll();
    }

    // 3. REMOVIDO O 'static' DAQUI TAMBÉM
    public static VeiculoModel salvar(VeiculoModel veiculo) {
        // 4. CORRIGIDO: Usando 'veiculoRepository' com "v" minúsculo
        return VeiculoRepository.save(veiculo);
    }
}