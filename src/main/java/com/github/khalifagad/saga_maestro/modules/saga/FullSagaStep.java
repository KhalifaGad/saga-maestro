package com.github.khalifagad.saga_maestro.modules.saga;

import com.github.khalifagad.saga_maestro.modules.endpoint.EndpointWithActor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class FullSagaStep {
    private SagaStep sagaStep;
    private EndpointWithActor endpointWithActor;
    private EndpointWithActor rollbackEndpointWithActor;
}
