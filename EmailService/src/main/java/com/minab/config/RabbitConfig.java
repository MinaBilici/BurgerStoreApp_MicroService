package com.minab.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    String exchange="exchange.direct";

    String activationCodeQueueName="activation.code.queue";
    String activationCodeBindingKey="activation.code.key";

    @Bean
    DirectExchange exchangeDirect(){
        return new DirectExchange(exchange);
    }

    @Bean
    Queue activationCodeQueue(){
        return new Queue(activationCodeQueueName);
    }
    @Bean
    Binding bindingActivationCode(Queue activationCodeQueue, DirectExchange exchangeDirect){
        return BindingBuilder.bind(activationCodeQueue).to(exchangeDirect).with(activationCodeBindingKey);
    }
    @Bean
    MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
