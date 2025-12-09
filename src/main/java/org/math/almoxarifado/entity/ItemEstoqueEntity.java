package org.math.almoxarifado.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.math.almoxarifado.valueobject.Localizacao;

import java.time.Instant;

@Entity
@Table(name = "itens_estoque")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemEstoqueEntity {

    @Id
    private String itemId;
    private String pedidoId;
    private String produtoId;
    private String descricao;
    private Integer quantidade;

    @Embedded
    private Localizacao localizacao;

    @Enumerated(EnumType.STRING)
    private StatusItem status;
    private Instant criadoEm;
    private Instant atualizadoEm;

    public enum StatusItem {
        RESERVADO,
        EM_PREPARACAO,
        PREPARADO,
        DESPACHADO
    }
}
