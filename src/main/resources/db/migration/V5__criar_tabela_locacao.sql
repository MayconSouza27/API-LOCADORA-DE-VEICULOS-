CREATE TABLE tb_locacao (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            cliente_id BIGINT NOT NULL,
                            veiculo_id BIGINT NOT NULL,
                            checklist_retirada_id BIGINT,
                            checklist_devolucao_id BIGINT,
                            data_inicio TIMESTAMP NOT NULL,
                            data_fim_prevista TIMESTAMP,
                            data_devolucao_efetiva TIMESTAMP,
                            status VARCHAR(20) NOT NULL,
                            CONSTRAINT fk_locacao_cliente FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id),
                            CONSTRAINT fk_locacao_veiculo FOREIGN KEY (veiculo_id) REFERENCES tb_veiculos(id),
                            CONSTRAINT fk_locacao_chk_retirada FOREIGN KEY (checklist_retirada_id) REFERENCES tb_checklist(id),
                            CONSTRAINT fk_locacao_chk_devolucao FOREIGN KEY (checklist_devolucao_id) REFERENCES tb_checklist(id)
);