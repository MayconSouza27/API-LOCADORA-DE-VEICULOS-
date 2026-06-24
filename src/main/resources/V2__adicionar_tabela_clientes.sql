-- ==========================================================================================
-- EXPLICAÇÃO IMPORTANTE:
-- O sistema de migrations funciona de forma muito parecida com o GitHub, mas focado no banco de dados.
-- Cada arquivo de migration representa um "commit" ou uma nova versão do seu esquema.
-- Isso permite registrar o histórico de evolução das tabelas e garante que toda a equipe
-- tenha exatamente a mesma versão do banco rodando localmente de forma automatizada.
-- ==========================================================================================

-- Migration: V2 - Criação da tabela de clientes para a locadora
CREATE TABLE clientes (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          cpf VARCHAR(14) NOT NULL UNIQUE,
                          telefone VARCHAR(20),
                          data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);