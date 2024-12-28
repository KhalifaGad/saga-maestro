package com.github.khalifagad.saga_maestro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.lang.NonNull;

@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.github.khalifagad.saga_maestro")
public class MongoConfiguration extends AbstractReactiveMongoConfiguration {

    private final Environment env;

    public MongoConfiguration(Environment env) {
        this.env = env;
    }

    @Override
    @NonNull
    protected String getDatabaseName() {
        return env.getProperty("spring.data.mongodb.database", "saga_maestro");
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
