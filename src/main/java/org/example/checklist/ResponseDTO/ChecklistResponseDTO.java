package org.example.checklist.ResponseDTO;
import org.example.checklist.model.NivelCombustivel;
import java.time.LocalDateTime;

public record ChecklistResponseDTO(
        Long id,
        Long veiculoId,
        String placaVeiculo,
        NivelCombustivel nivelCombustivel,
        Boolean temAvarias,
        String observacoesAvarias,
        Boolean estaLimpo,
        LocalDateTime dataCriacao
) {}