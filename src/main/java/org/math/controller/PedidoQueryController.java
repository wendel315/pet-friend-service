package org.math.controller;

import org.math.entity.PedidoEntity;
import org.math.service.PedidoQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoQueryController {
    private final PedidoQueryService pedidoQueryService;

    public PedidoQueryController(PedidoQueryService pedidoQueryService) {
        this.pedidoQueryService = pedidoQueryService;
    }

    @GetMapping
    public ResponseEntity<List<PedidoEntity>> listarTodosPedidos() {
        List<PedidoEntity> pedidos = pedidoQueryService.listarTodosPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<PedidoEntity> buscarPedidoPorId(@PathVariable String pedidoId) {
        return pedidoQueryService.buscarPedidoPorId(pedidoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

