package org.math.transporte.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.math.transporte.valueobject.EnderecoEntrega;

import java.time.Instant;

@Entity
@Table(name = "entregas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntregaEntity {

    @Id
    private String entregaId;
    private String pedidoId;
    private String clienteId;

    @Embedded
    private EnderecoEntrega enderecoEntrega;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;
    private String codigoRastreio;
    private Instant criadoEm;
    private Instant atualizadoEm;
    private Instant entregueEm;

    public enum StatusEntrega {
        EM_TRANSITO,
        ENTREGUE,
        DEVOLVIDO,
        EXTRAVIADO
    }
}
