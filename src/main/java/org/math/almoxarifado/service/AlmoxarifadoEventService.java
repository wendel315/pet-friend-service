package org.math.almoxarifado.service;

import org.math.almoxarifado.config.AlmoxarifadoRabbitMQConfig;
import org.math.almoxarifado.entity.ItemEstoqueEntity;
import org.math.almoxarifado.repository.ItemEstoqueRepository;
import org.math.almoxarifado.valueobject.Localizacao;
import org.math.pedidos.event.PedidoEnviadoParaAlmoxarifadoEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class AlmoxarifadoEventService {

    private final ItemEstoqueRepository itemEstoqueRepository;

    public AlmoxarifadoEventService(ItemEstoqueRepository itemEstoqueRepository) {
        this.itemEstoqueRepository = itemEstoqueRepository;
    }

    @RabbitListener(queues = AlmoxarifadoRabbitMQConfig.QUEUE_ALMOXARIFADO)
    public void processarPedidoEnviado(PedidoEnviadoParaAlmoxarifadoEvent event) {
        for (PedidoEnviadoParaAlmoxarifadoEvent.ItemPedido item : event.getItens()) {
            ItemEstoqueEntity itemEstoque = new ItemEstoqueEntity(
                    UUID.randomUUID().toString(),
                    event.getPedidoId(),
                    item.getProdutoId(),
                    item.getDescricao(),
                    item.getQuantidade(),
                    new Localizacao("A", "1", "01"),
                    ItemEstoqueEntity.StatusItem.RESERVADO,
                    Instant.now(),
                    Instant.now()
            );
            itemEstoqueRepository.save(itemEstoque);
        }
    }
}
