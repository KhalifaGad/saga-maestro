package com.github.khalifagad.saga_maestro.modules.saga;

import com.github.khalifagad.saga_maestro.modules.endpoint.EndpointService;
import com.github.khalifagad.saga_maestro.modules.endpoint.EndpointWithActor;
import com.github.khalifagad.saga_maestro.modules.saga.dto.CreateSagaDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SagaService {
    private final SagaRepository sagaRepository;
    private final ModelMapper modelMapper;
    private final EndpointService endpointService;

    public SagaService(SagaRepository sagaRepository, ModelMapper modelMapper, EndpointService endpointService) {
        this.sagaRepository = sagaRepository;
        this.modelMapper = modelMapper;
        this.endpointService = endpointService;
    }

    Mono<Saga> create(CreateSagaDto payload) {
        var saga = modelMapper.map(payload, Saga.class);
        return sagaRepository.save(saga);
    }

    Flux<SagaWithFullSteps> list() {
        return sagaRepository.findAll().collectList().flatMapMany(this::addSagaStepRelations);
    }

    private Flux<SagaWithFullSteps> addSagaStepRelations(List<Saga> sagas) {
        if (CollectionUtils.isEmpty(sagas)) {
            return Flux.empty();
        }
        Set<String> endpointIdsSet = sagas.stream()
                .flatMap(saga -> Arrays.stream(saga.getSteps()))
                .<String>mapMulti((sagaStep, downstream) -> {
                    downstream.accept(sagaStep.getEndpointId());
                    if (sagaStep.getRollbackEndpointId() != null) {
                        downstream.accept(sagaStep.getRollbackEndpointId());
                    }
                }).collect(Collectors.toSet());

        Mono<Map<String, EndpointWithActor>> endpointWithActorMapMono = endpointService.listByIds(endpointIdsSet).collectMap(endpointWithActor -> endpointWithActor.getEndpoint().getId());

        return Flux.fromIterable(sagas)
                .zipWith(endpointWithActorMapMono,
                        (saga, endpointWithActorMap) -> {
                            var steps = Arrays.stream(saga.getSteps())
                                    .map(sagaStep -> {
                                        var endpoint = endpointWithActorMap.get(sagaStep.getEndpointId());
                                        var rollbackEndpointId = sagaStep.getRollbackEndpointId();
                                        var rollbackEndpoint = rollbackEndpointId != null ? endpointWithActorMap.get(rollbackEndpointId) : null;
                                        return new FullSagaStep(sagaStep, endpoint, rollbackEndpoint);
                                    })
                                    .toArray(FullSagaStep[]::new);
                            return new SagaWithFullSteps(saga, steps);
                        });
    }
}
