package be.fgov.famhp.plato.outbox.config;

import be.fgov.fagg.common.outbox.publisher.OutboxChangeStreamService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;

@Configuration
public class PlatoOutboxTestConfiguration {


    @MockBean
    ReactiveMongoTemplate backOfficeDataReactiveMongoTemplate;

    @MockBean
    SimpleReactiveMongoDatabaseFactory backOfficeDataReactiveMongoFactory;

    @MockBean
    OutboxChangeStreamService outboxChangeStreamService;

    @Bean("backOfficeDataReactiveMongoTemplate")
    public ReactiveMongoTemplate backOfficeDataReactiveMongoTemplate() {
        return backOfficeDataReactiveMongoTemplate;
    }
    @Bean("backOfficeDataReactiveMongoFactory")
    public SimpleReactiveMongoDatabaseFactory backOfficeDataReactiveMongoFactory() {
        return backOfficeDataReactiveMongoFactory;
    }

    @Bean
    public OutboxChangeStreamService outboxChangeStreamService(MongoTemplate mongoTemplate, ReactiveMongoTemplate backOfficeDataReactiveMongoTemplate, String tokenKey, RabbitTemplate rabbitTemplate, TopicExchange topicExchange, String routingKey){
        return new OutboxChangeStreamService(mongoTemplate,
            backOfficeDataReactiveMongoTemplate,
            "TEST",
            rabbitTemplate,
            topicExchange,
            "PLATO.TEST");
    }
}
