package be.fgov.famhp.plato.outbox.config;


import be.fgov.fagg.common.outbox.publisher.OutboxChangeStreamService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
public class OutBoxConfiguration {

    @Bean
    OutboxChangeStreamService outboxChangeStreamService(MongoTemplate mongoTemplate, ReactiveMongoTemplate backOfficeDataReactiveMongoTemplate, RabbitTemplate rabbitTemplate, TopicExchange topicExchange, ObjectMapper objectMapper) {
        return new OutboxChangeStreamService(mongoTemplate,
            backOfficeDataReactiveMongoTemplate,
            "PLATO_BACKOFFICE_JV_SNAPSHOT",
            rabbitTemplate,
            topicExchange,
            "PLATO.OUTBOX.BACKOFFICE");
    }
}
