package org.math.controller;

import org.math.dto.CriarPedidoRequest;
import org.math.service.PedidoCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoCommandController {
    private final PedidoCommandService pedidoCommandService;

    public PedidoCommandController(PedidoCommandService pedidoCommandService) {
        this.pedidoCommandService = pedidoCommandService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<String>> criarPedido(@RequestBody CriarPedidoRequest request) {
        return pedidoCommandService.criarPedido(
                request.getClienteId(),
                request.getPetId(),
                request.getDescricao(),
                request.getValor()
        ).thenApply(pedidoId -> ResponseEntity.status(HttpStatus.CREATED).body(pedidoId));
    }
}

