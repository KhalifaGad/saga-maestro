package com.github.khalifagad.saga_maestro.modules.actor;

import com.github.khalifagad.saga_maestro.modules.actor.dto.CreateActorDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActorService {
    private final ActorRepository actorRepository;
    private final ModelMapper modelMapper;

    ActorService(ActorRepository actorRepository, ModelMapper modelMapper) {
        this.actorRepository = actorRepository;
        this.modelMapper = modelMapper;
    }


    Mono<Actor> create(CreateActorDto payload) {
        Actor actor = modelMapper.map(payload, Actor.class);
        return actorRepository.save(actor);
    }

    Flux<Actor> list() {
        return actorRepository.findAll();
    }

    public Flux<Actor> listByIds(Iterable<String> ids) {
        return actorRepository.findAllById(ids);
    }

}
