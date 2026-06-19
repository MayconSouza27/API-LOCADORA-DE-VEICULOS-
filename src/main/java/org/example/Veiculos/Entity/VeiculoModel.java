package org.example.Veiculos.Entity;import jakarta.persistence.*; // Importa as anotações do JPA para persistência no banco
import lombok.*; // Importa as anotações do Lombok para reduzir código repetitivo
import java.time.LocalDateTime; // Importa a classe para manipulação de data e hora

// Anotações do Lombok que geram métodos automaticamente em tempo de compilação
@Getter // Gera todos os métodos 'get' para os atributos
@Setter // Gera todos os métodos 'set' para os atributos
@NoArgsConstructor // Gera um construtor vazio (obrigatório para o Hibernate funcionar)
@AllArgsConstructor // Gera um construtor que aceita todos os campos da classe
@Entity // Define que esta classe será mapeada para uma tabela no banco de dados
@Table(name = "tb_veiculos") // Especifica o nome da tabela no MySQL; se omitido, usaria o nome da classe
public class VeiculoModel {

    // Define a Chave Primária (ID)
    @Id
    // Configura o ID para ser incrementado automaticamente pelo banco (Auto-Increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Coluna 'placa' com restrições: obrigatória (nullable = false), única no banco (unique = true)
    // e tamanho máximo de 7 caracteres
    @Column(name = "placa", nullable = false, unique = true, length = 7)
    private String placa;

    // Coluna para a marca, obrigatória, com até 50 caracteres
    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    // Coluna para o modelo, obrigatória, com até 50 caracteres
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    // Coluna para ano de fabricação, campo obrigatório
    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;

    // Coluna para cor, opcional (nullable = true por padrão), até 30 caracteres
    @Column(name = "cor", length = 30)
    private String cor;

    // Define se o veículo está ativo no sistema; iniciamos como 'true' por padrão
    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    // Armazena a data de cadastro; é um campo obrigatório
    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro;

    // Método que é disparado automaticamente pelo JPA antes do objeto ser salvo no banco
    @PrePersist
    protected void onCreate() {
        // Define o horário atual como o momento do registro, evitando entrada manual do usuário
        this.dataCadastro = LocalDateTime.now();

    }
}