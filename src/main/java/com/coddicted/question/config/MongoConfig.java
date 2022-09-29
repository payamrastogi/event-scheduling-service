package com.coddicted.question.config;

import com.coddicted.question.listener.CascadeSaveMongoEventListener;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.coddicted")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "questions_db";
    }

    @Override
    public MongoClient mongoClient() {
        final ConnectionString connectionString = new ConnectionString("mongodb://192.168.1.44:27017/question_db");
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public CascadeSaveMongoEventListener cascadingMongoEventListener() {
        return new CascadeSaveMongoEventListener();
    }
}
