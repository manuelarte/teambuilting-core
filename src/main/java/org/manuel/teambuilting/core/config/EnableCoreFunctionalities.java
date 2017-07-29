package org.manuel.teambuilting.core.config;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@PropertySource("classpath:teambuilting-core-application.properties")
@Import({ RabbitMQConfig.class, SecurityConfig.class, WebConfig.class})
@EntityScan
/**
 * @author Manuel Doncel Martos
 * @since 29/07/2017.
 */
public @interface EnableCoreFunctionalities {

}