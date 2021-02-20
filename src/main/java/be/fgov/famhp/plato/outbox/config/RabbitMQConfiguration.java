package be.fgov.famhp.plato.outbox.config;

import be.fgov.fagg.common.config.FamhpRabbitMQAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(FamhpRabbitMQAutoConfiguration.class)
public class RabbitMQConfiguration {


}
