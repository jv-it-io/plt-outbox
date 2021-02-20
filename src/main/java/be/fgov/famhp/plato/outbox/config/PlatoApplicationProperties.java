package be.fgov.famhp.plato.outbox.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "applicationplato", ignoreUnknownFields = false)
public class PlatoApplicationProperties {

    MongoProperties platoBackOffice = new MongoProperties();

    public MongoProperties getPlatoBackOffice() {
        return platoBackOffice;
    }

    public void setPlatoBackOffice(MongoProperties platoBackOffice) {
        this.platoBackOffice = platoBackOffice;
    }
}
