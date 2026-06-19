package org.example.Model;

import jakarta.persistence.*; // Importa as anotações do JPA para mapeamento de banco de dados
import lombok.*; // Importa o Lombok para reduzir código repetitivo (Boilerplate)
import java.time.LocalDateTime; // Importa para manipular datas e horas

// @Entity: Indica que esta classe será uma tabela no seu banco de dados
// @Table: Define o nome da tabela no SQL como "tb_checklist"
@Data
@Entity
@Table(name = "tb_checklist")

// Anotações do Lombok que geram automaticamente os métodos necessários:
@Getter // Cria todos os métodos de leitura (getters)
@Setter // Cria todos os métodos de escrita (setters)
@NoArgsConstructor // Cria um construtor vazio (exigência do Hibernate)
@AllArgsConstructor // Cria um construtor com todos os campos preenchidos
public class ChecklistModell {

    // @Id: Define que este campo é a Chave Primária
    // @GeneratedValue: Define que o banco de dados gerará o ID automaticamente (auto-incremento)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: Define propriedades da coluna no banco
    // nullable = false: Impede que o registro seja salvo sem preencher este campo
    @Column(name = "placa_veiculo", nullable = false, length = 7)
    private String placaVeiculo; // Mudou de placa_veiculo para placaVeiculo

    // @Enumerated: Grava o nome do valor da Enum (ex: "ENTRADA") em vez de um número (0, 1)


    @Enumerated(EnumType.STRING)
    private NivelCombustivel nivelCombustivel;

    @Column(name = "tipo_checklist", nullable = false, length = 20)
    private String tipoChecklist;

    @Column(name = "quilometrage", nullable = false)
    private Long quilometragem;

    @Column(name = "tem_estepe", nullable = false)
    private Boolean temEstepe;

    @Column(name = "tem_macaco_chave_roda", nullable = false)
    private Boolean temMacacoChaveDeRoda;

    @Column(name = "limpo_interno", nullable = false)
    private Boolean limpoInterno;

    @Column(name = "limpo_externo", nullable = false)
    private Boolean limpoExterno;

    // columnDefinition = "TEXT" permite textos mais longos do que uma coluna de String comum
    @Column(name = "observacoes_avarias", columnDefinition = "TEXT")
    private String observacoesAvarias;

    @Column(name = "data_registro", nullable = false)
    private LocalDateTime dataRegistro;

    // @PrePersist: Executa este método automaticamente ANTES de salvar no banco
    // Ideal para preencher a data de criação sem precisar enviá-la via JSON
    @PrePersist
    protected void onCreate() {
        this.dataRegistro = LocalDateTime.now(); // Captura o momento exato do registro
    }
}