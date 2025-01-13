package com.github.khalifagad.saga_maestro.modules.saga;

import lombok.Getter;
import lombok.Setter;

@lombok.AllArgsConstructor
@Setter
@Getter
public class SagaWithFullSteps {
    private Saga saga;
    private FullSagaStep[] steps;
}
