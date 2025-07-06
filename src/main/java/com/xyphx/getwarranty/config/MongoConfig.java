package com.xyphx.getwarranty.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableMongoAuditing
public class MongoConfig {

    @Bean
    MongoClient mongoClient() {
        String uri = System.getenv("MONGODB_URI");

        try {
            MongoClient client = MongoClients.create(uri);
            client.getDatabase("admin").runCommand(new Document("ping", 1));
            System.out.println("✅ MongoDB connection SUCCESS ✅");
            return client;
        } catch (Exception e) {
            System.out.println("❌ MongoDB connection FAILED ❌ " + e);
            throw e;
        }
    }

    @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "getwarranty");
    }
}
