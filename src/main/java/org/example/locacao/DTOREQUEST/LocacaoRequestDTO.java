package org.example.locacao.DTOREQUEST;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record LocacaoRequestDTO(
        @NotNull(message = "O ID do cliente é obrigatório")
        Long clienteId,

        @NotNull(message = "O ID do veículo é obrigatório")
        Long veiculoId,

        @NotNull(message = "A data de início é obrigatória")
        LocalDateTime dataInicio,

        LocalDateTime dataFimPrevista,

        @NotNull(message = "O status é obrigatório")
        String status
) {}