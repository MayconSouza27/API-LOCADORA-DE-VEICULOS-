package org.example.checklist.RequestDTO;

import jakarta.validation.constraints.NotNull;
import org.example.checklist.model.NivelCombustivel;

public record ChecklistRequestDTO(
        @NotNull(message = "O ID do veículo é obrigatório")
        Long veiculoId,

        @NotNull(message = "O nível de combustível é obrigatório")
        NivelCombustivel nivelCombustivel,

        @NotNull(message = "Informe se o veículo possui avarias")
        Boolean temAvarias,

        String observacoesAvarias,

        @NotNull(message = "Informe se o veículo está limpo")
        Boolean estaLimpo
) {}