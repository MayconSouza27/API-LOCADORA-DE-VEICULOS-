package org.example.cliente.DTOResponse;

public record ClienteDTOResponse(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone
) {}