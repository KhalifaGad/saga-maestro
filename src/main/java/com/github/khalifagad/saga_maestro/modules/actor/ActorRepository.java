package com.github.khalifagad.saga_maestro.modules.actor;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface ActorRepository extends ReactiveSortingRepository<Actor, String> {
}
