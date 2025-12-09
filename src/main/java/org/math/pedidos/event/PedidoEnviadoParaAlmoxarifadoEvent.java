package org.math.pedidos.event;

import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
public class PedidoEnviadoParaAlmoxarifadoEvent {

    private final String pedidoId;
    private final String clienteId;
    private final List<ItemPedido> itens;
    private final Instant occurredOn;

    public PedidoEnviadoParaAlmoxarifadoEvent(String pedidoId, String clienteId, List<ItemPedido> itens) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.itens = itens;
        this.occurredOn = Instant.now();
    }

    @Getter
    public static class ItemPedido {
        private final String produtoId;
        private final String descricao;
        private final Integer quantidade;

        public ItemPedido(String produtoId, String descricao, Integer quantidade) {
            this.produtoId = produtoId;
            this.descricao = descricao;
            this.quantidade = quantidade;
        }
    }
}
