package com.github.khalifagad.saga_maestro.modules.saga;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface SagaRepository extends ReactiveSortingRepository<Saga, String> {
    Mono<Saga> findSagaByName(String name);
}
