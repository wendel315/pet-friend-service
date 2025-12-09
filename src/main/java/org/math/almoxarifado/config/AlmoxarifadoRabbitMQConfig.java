package org.math.almoxarifado.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlmoxarifadoRabbitMQConfig {

    public static final String QUEUE_ALMOXARIFADO = "pedidos.almoxarifado.queue";
    public static final String EXCHANGE_PEDIDOS = "pedidos.exchange";
    public static final String ROUTING_KEY_ALMOXARIFADO = "pedido.enviado.almoxarifado";

    @Bean
    public Queue almoxarifadoQueue() {
        return new Queue(QUEUE_ALMOXARIFADO, true);
    }

    @Bean
    public TopicExchange pedidosExchange() {
        return new TopicExchange(EXCHANGE_PEDIDOS);
    }

    @Bean
    public Binding almoxarifadoBinding(Queue almoxarifadoQueue, TopicExchange pedidosExchange) {
        return BindingBuilder
                .bind(almoxarifadoQueue)
                .to(pedidosExchange)
                .with(ROUTING_KEY_ALMOXARIFADO);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
