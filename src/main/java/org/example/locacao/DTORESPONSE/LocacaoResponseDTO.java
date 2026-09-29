package org.example.locacao.DTORESPONSE;

import java.time.LocalDateTime;

public record LocacaoResponseDTO(
        Long id,
        Long clienteId,
        String nomeCliente,
        Long veiculoId,
        String modeloVeiculo,
        LocalDateTime dataInicio,
        LocalDateTime dataFimPrevista,
        String status
) {}