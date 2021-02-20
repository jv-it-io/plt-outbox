package be.fgov.famhp.plato.outbox.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Document(collection = "changeStreamStatus")
public class ChangeStreamStatus {

    @Id
    private String id;

    @Field
    private Instant timestamp;

    @Field
    private String token;

    @Field
    private String type;

    @Field
    private String operation;

    @Field
    private org.bson.Document body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public org.bson.Document getBody() {
        return body;
    }

    public void setBody(org.bson.Document body) {
        this.body = body;
    }

}
