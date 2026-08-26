package org.example.checklist.exception;
// Disparada ao tentar cadastrar ou atualizar um veículo com uma placa já existente
public class PlacaDuplicadaException extends RuntimeException {
    public PlacaDuplicadaException(String message) {
        super(message);
    }
}