package com.github.khalifagad.saga_maestro.modules.actor;

import com.github.khalifagad.saga_maestro.modules.actor.dto.CreateActorDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
class ActorController {
    private final ActorService actorService;

    ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("/actors")
    Mono<Actor> create(@Valid @RequestBody CreateActorDto payload) {
        return actorService.create(payload);
    }

    @GetMapping("/actors")
    Flux<Actor> list() {
        return actorService.list();
    }
}
