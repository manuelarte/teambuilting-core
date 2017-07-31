package org.manuel.teambuilting.core.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Manuel Doncel Martos
 * @since 07/12/2016.
 */
@Configuration
@PropertySource("classpath:config/messaging.properties")
public class RabbitMQConfig  {

	private final String exchange;
	private final boolean durable;
	private final boolean autodelete;
	private final AmqpAdmin rabbitAdmin;

	public RabbitMQConfig(final @Value("${messaging.amqp.team.exchange.name}") String exchange, final @Value("${messaging.amqp.team.exchange.durable}") boolean durable,
		final @Value("${messaging.amqp.team.exchange.autodelete}") boolean autodelete, final AmqpAdmin rabbitAdmin) {
    	this.exchange = exchange;
    	this.durable = durable;
    	this.autodelete = autodelete;
		this.rabbitAdmin = rabbitAdmin;

	}

    @PostConstruct
    private void declareExchange() {
        rabbitAdmin.declareExchange(new TopicExchange(exchange, durable, autodelete));
    }

    @Bean(name = "eventMessageConverter")
    public MessageConverter messageConverter(final ObjectMapper jsonObjectMapper) {
	    return new Jackson2JsonMessageConverter(jsonObjectMapper);
    }

}