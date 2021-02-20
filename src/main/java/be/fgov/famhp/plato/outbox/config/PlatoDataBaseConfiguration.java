package be.fgov.famhp.plato.outbox.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import com.mongodb.reactivestreams.client.MongoClients;


@Configuration
@EnableMongoRepositories(value = "be.fgov.famhp.plato.outbox.repository", mongoTemplateRef = "mongoTemplate")
@EnableReactiveMongoRepositories(value = "be.fgov.famhp.plato.outbox.repository", reactiveMongoTemplateRef = "reactiveMongoPlato")
public class PlatoDataBaseConfiguration {

    private final Logger log = LoggerFactory.getLogger(PlatoDataBaseConfiguration.class);

    private final PlatoApplicationProperties applicationProperties;

    public PlatoDataBaseConfiguration(PlatoApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Bean("backOfficeDataReactiveMongoTemplate")
    public ReactiveMongoTemplate backOfficeDataReactiveMongoTemplate(@Qualifier("backOfficeDataReactiveMongoFactory") ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory) {
        return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory);
    }
    @Bean("backOfficeDataReactiveMongoFactory")
    public SimpleReactiveMongoDatabaseFactory backOfficeDataReactiveMongoFactory() {
        MongoProperties mongoProperties = applicationProperties.getPlatoBackOffice();
        return new SimpleReactiveMongoDatabaseFactory(MongoClients.create(mongoProperties.getUri()), mongoProperties.getDatabase());
    }
}
