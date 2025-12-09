package org.math.transporte.service;

import org.math.pedidos.event.PedidoDespachadoParaTransporteEvent;
import org.math.transporte.config.TransporteRabbitMQConfig;
import org.math.transporte.entity.EntregaEntity;
import org.math.transporte.repository.EntregaRepository;
import org.math.transporte.valueobject.EnderecoEntrega;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class TransporteEventService {

    private final EntregaRepository entregaRepository;

    public TransporteEventService(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    @RabbitListener(queues = TransporteRabbitMQConfig.QUEUE_TRANSPORTE)
    public void processarPedidoDespachado(PedidoDespachadoParaTransporteEvent event) {
        PedidoDespachadoParaTransporteEvent.EnderecoDestinatario endereco = event.getEnderecoDestinatario();

        EntregaEntity entrega = new EntregaEntity(
                UUID.randomUUID().toString(),
                event.getPedidoId(),
                event.getClienteId(),
                new EnderecoEntrega(
                        endereco.getLogradouro(),
                        endereco.getNumero(),
                        endereco.getComplemento(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getEstado(),
                        endereco.getCep()
                ),
                EntregaEntity.StatusEntrega.EM_TRANSITO,
                gerarCodigoRastreio(),
                Instant.now(),
                Instant.now(),
                null
        );

        entregaRepository.save(entrega);
    }

    private String gerarCodigoRastreio() {
        return "PF" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
