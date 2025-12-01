package org.math.service;

import org.math.entity.PedidoEntity;
import org.math.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoQueryService {
    private final PedidoRepository pedidoRepository;

    public PedidoQueryService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoEntity> listarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoEntity> buscarPedidoPorId(String pedidoId) {
        return pedidoRepository.findById(pedidoId);
    }
}

