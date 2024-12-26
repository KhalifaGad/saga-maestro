package com.github.khalifagad.saga_maestro.modules.endpoint;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface EndpointRepository extends ReactiveSortingRepository<Endpoint, String> {
}
