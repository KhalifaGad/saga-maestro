package com.github.khalifagad.saga_maestro.modules.saga;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface SagaRepository extends ReactiveMongoRepository<Saga, String> {
    Mono<Saga> findSagaByName(String name);
}
