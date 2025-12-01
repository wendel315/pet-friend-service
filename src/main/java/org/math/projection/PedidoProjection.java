package org.math.projection;

import org.axonframework.eventhandling.EventHandler;
import org.math.entity.PedidoEntity;
import org.math.event.PedidoCriadoEvent;
import org.math.repository.PedidoRepository;
import org.springframework.stereotype.Component;

@Component
public class PedidoProjection {
    private final PedidoRepository pedidoRepository;

    public PedidoProjection(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @EventHandler
    public void on(PedidoCriadoEvent event) {
        PedidoEntity pedido = new PedidoEntity(
                event.getAggregateId(),
                event.getClienteId(),
                event.getPetId(),
                event.getDescricao(),
                event.getValor(),
                event.getOccurredOn()
        );
        pedidoRepository.save(pedido);
    }
}

