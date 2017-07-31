package org.manuel.teambuilting.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author Manuel Doncel Martos
 * @since 31/07/2017.
 */
@Component
@ConfigurationProperties(prefix = "messaging")
@Validated
@Data
public class MessagingProperties {

    @NotNull
    private AmqpProperties amqp;

    @Validated
    @Data
    public static final class AmqpProperties {
        @NotNull
        private ExchangeProperties team;

        @NotNull
        private ExchangeProperties player;
    }

    @Validated
    @Data
    public static final class ExchangeProperties {
        @NotNull
        private String name;

        private String durable;

        private String autodelete;
    }

}
