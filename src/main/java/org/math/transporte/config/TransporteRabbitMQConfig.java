package org.math.transporte.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransporteRabbitMQConfig {

    public static final String QUEUE_TRANSPORTE = "pedidos.transporte.queue";
    public static final String EXCHANGE_PEDIDOS = "pedidos.exchange";
    public static final String ROUTING_KEY_TRANSPORTE = "pedido.despachado.transporte";

    @Bean
    public Queue transporteQueue() {
        return new Queue(QUEUE_TRANSPORTE, true);
    }

    @Bean
    public Binding transporteBinding(Queue transporteQueue, TopicExchange pedidosExchange) {
        return BindingBuilder
                .bind(transporteQueue)
                .to(pedidosExchange)
                .with(ROUTING_KEY_TRANSPORTE);
    }
}
