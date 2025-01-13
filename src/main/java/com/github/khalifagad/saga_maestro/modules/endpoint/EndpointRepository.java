package com.github.khalifagad.saga_maestro.modules.endpoint;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

interface EndpointRepository extends ReactiveMongoRepository<Endpoint, String> {
}
