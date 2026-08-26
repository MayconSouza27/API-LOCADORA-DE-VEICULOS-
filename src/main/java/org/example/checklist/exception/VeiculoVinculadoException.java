package org.example.checklist.exception;
// Disparada ao tentar excluir um veículo que possui dependências em outras tabelas
public class VeiculoVinculadoException extends RuntimeException {
    public VeiculoVinculadoException(String message) {
        super(message);
    }
}