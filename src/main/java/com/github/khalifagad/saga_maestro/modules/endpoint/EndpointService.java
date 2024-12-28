package com.github.khalifagad.saga_maestro.modules.endpoint;

import com.github.khalifagad.saga_maestro.modules.actor.Actor;
import com.github.khalifagad.saga_maestro.modules.actor.ActorService;
import com.github.khalifagad.saga_maestro.modules.endpoint.dto.CreateEndpointDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EndpointService {
    private final EndpointRepository endpointRepository;
    private final ModelMapper modelMapper;
    private final ActorService actorService;

    EndpointService(ActorService actorService, EndpointRepository endpointRepository, ModelMapper modelMapper) {
        this.endpointRepository = endpointRepository;
        this.modelMapper = modelMapper;
        this.actorService = actorService;
    }

    Mono<Endpoint> create(CreateEndpointDto payload) {
        Endpoint endpoint = modelMapper.map(payload, Endpoint.class);
        return endpointRepository.save(endpoint);
    }

    public Flux<EndpointWithActor> listByIds(Iterable<String> ids) {
        return endpointRepository.findAllById(ids).collectList().flatMapMany(this::addActorsToEndpoints);
    }

    Flux<EndpointWithActor> list() {
        return endpointRepository.findAll().collectList().flatMapMany(this::addActorsToEndpoints);
    }

    private Flux<EndpointWithActor> addActorsToEndpoints(List<Endpoint> endpoints) {
        if (CollectionUtils.isEmpty(endpoints)) {
            return Flux.empty();
        }
        Set<String> actorIds = endpoints.stream().map(Endpoint::getActorId).collect(Collectors.toSet());
        Mono<Map<String, Actor>> actorsMapMono = actorService.listByIds(actorIds).collectMap(Actor::getId);

        return Flux.fromIterable(endpoints)
                .zipWith(actorsMapMono,
                        (endpoint, actorsMap) ->
                                new EndpointWithActor(endpoint, actorsMap.get(endpoint.getActorId())));
    }
}
