package com.github.khalifagad.saga_maestro.modules.actor;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

interface ActorRepository extends ReactiveMongoRepository<Actor, String> {
}
