-- Criação da tabela de Veículos
CREATE TABLE veiculos (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          placa VARCHAR(10) NOT NULL UNIQUE,
                          marca VARCHAR(50) NOT NULL,
                          modelo VARCHAR(50) NOT NULL,
                          ano_fabricacao INT NOT NULL,
                          cor VARCHAR(30) NOT NULL,
                          ativo BOOLEAN NOT NULL
);

-- Criação da tabela de Clientes
CREATE TABLE clientes (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          cpf VARCHAR(14) NOT NULL UNIQUE,
                          email VARCHAR(100) NOT NULL,
                          telefone VARCHAR(20) NOT NULL
);

-- Criação da tabela de Checklists
CREATE TABLE checklists (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            placa_veiculo VARCHAR(10) NOT NULL,
                            nivel_combustivel VARCHAR(20) NOT NULL,
                            tipo_checklist VARCHAR(20) NOT NULL,
                            quilometragem INT NOT NULL,
                            tem_estepe BOOLEAN NOT NULL,
                            tem_macaco_chave_de_roda BOOLEAN NOT NULL,
                            limpo_interno BOOLEAN NOT NULL,
                            limpo_externo BOOLEAN NOT NULL,
                            observacoes_avarias TEXT,
                            veiculo_id BIGINT NOT NULL,
                            CONSTRAINT fk_checklist_veiculo FOREIGN KEY (veiculo_id) REFERENCES veiculos(id)
);

-- Criação da tabela de Locações
CREATE TABLE locacoes (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          cliente_id BIGINT NOT NULL,
                          veiculo_id BIGINT NOT NULL,
                          data_inicio TIMESTAMP NOT NULL,
                          data_fim_prevista TIMESTAMP NOT NULL,
                          data_devolucao_efetiva TIMESTAMP,
                          status VARCHAR(30) NOT NULL,
                          CONSTRAINT fk_locacao_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id),
                          CONSTRAINT fk_locacao_veiculo FOREIGN KEY (veiculo_id) REFERENCES veiculos(id)
);