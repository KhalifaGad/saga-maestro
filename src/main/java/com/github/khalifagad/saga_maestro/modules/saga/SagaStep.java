package com.github.khalifagad.saga_maestro.modules.saga;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SagaStep {
    private String id;

    private SagaStepExecutionType executionType = SagaStepExecutionType.SEQUENTIAL;
    private SagaStepOnFailureOption onFailureAction = SagaStepOnFailureOption.ROLLBACK;

    private String endpointId;

    @Nullable
    private String rollbackEndpointId;
}
