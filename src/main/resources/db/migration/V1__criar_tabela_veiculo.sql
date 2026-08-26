CREATE TABLE tb_veiculos (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             placa VARCHAR(10) NOT NULL,
                             modelo VARCHAR(50) NOT NULL,
                             marca VARCHAR(50) NOT NULL,
                             cor VARCHAR(30),
                             ano_fabricacao INT,
                             ativo BOOLEAN,
                             data_cadastro TIMESTAMP
);