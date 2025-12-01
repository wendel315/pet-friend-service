package org.math.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.math.command.CriarPedidoCommand;
import org.math.event.PedidoCriadoEvent;

@Aggregate
public class PedidoAggregate {
    @AggregateIdentifier
    private String pedidoId;
    private String clienteId;
    private String petId;
    private String descricao;
    private Double valor;

    public PedidoAggregate() {
    }

    @CommandHandler
    public PedidoAggregate(CriarPedidoCommand command) {
        AggregateLifecycle.apply(new PedidoCriadoEvent(
                command.getAggregateId(),
                command.getClienteId(),
                command.getPetId(),
                command.getDescricao(),
                command.getValor()
        ));
    }

    @EventSourcingHandler
    public void on(PedidoCriadoEvent event) {
        this.pedidoId = event.getAggregateId();
        this.clienteId = event.getClienteId();
        this.petId = event.getPetId();
        this.descricao = event.getDescricao();
        this.valor = event.getValor();
    }
}

