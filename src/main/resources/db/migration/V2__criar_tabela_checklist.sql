
CREATE TABLE tb_checklist (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              tipo_checklist VARCHAR(20) NOT NULL,
                              quilometragm BIGINT NOT NULL,
                              tem_estepe BOOLEAN NOT NULL,
                              tem_macaco_chave_roda BOOLEAN NOT NULL,
                              limpo_interno BOOLEAN NOT NULL,
                              limpo_externo BOOLEAN NOT NULL,
                              nivel_combustivel INT NOT NULL,
                              observacoes_avarias TEXT,
                              data_registro TIMESTAMP,
                              placa_veiculo VARCHAR(20),
                              veiculo_id BIGINT NOT NULL,
                              CONSTRAINT fk_checklist_veiculo FOREIGN KEY (veiculo_id) REFERENCES tb_veiculos(id)
);