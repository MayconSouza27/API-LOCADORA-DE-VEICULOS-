package org.example.veiculo.VeiculoDTOResponse;

import java.math.BigDecimal;

public record VeiculoResponseDTO(
        Long id,
        String marca,
        String modelo,
        String placa,
        Integer ano,
        BigDecimal valorDiaria,
        String status
) {}