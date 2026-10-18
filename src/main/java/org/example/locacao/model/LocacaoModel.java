package org.example.locacao.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.cliente.model.Cliente;
import org.example.veiculo.model.VeiculoModel;
import org.example.checklist.model.ChecklistModell;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_locacao")
public class LocacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private VeiculoModel veiculo;

    @ManyToOne
    @JoinColumn(name = "checklist_retirada_id")
    private ChecklistModell checklistRetirada;

    @ManyToOne
    @JoinColumn(name = "checklist_devolucao_id")
    private ChecklistModell checklistDevolucao;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "data_fim_prevista")
    private LocalDateTime dataFimPrevista;

    @Column(name = "data_devolucao_efetiva")
    private LocalDateTime dataDevolucaoEfetiva;

    @Column(name = "status", nullable = false, length = 20)
    private String status;
}