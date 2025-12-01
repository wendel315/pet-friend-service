package org.math.service;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.math.command.CriarPedidoCommand;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandService {
    private final CommandGateway commandGateway;

    public PedidoCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> criarPedido(String clienteId, String petId, String descricao, Double valor) {
        String pedidoId = UUID.randomUUID().toString();
        CriarPedidoCommand command = new CriarPedidoCommand(pedidoId, clienteId, petId, descricao, valor);
        return commandGateway.send(command);
    }
}

