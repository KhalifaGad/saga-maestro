package com.github.khalifagad.saga_maestro.modules.saga.dto;

import com.github.khalifagad.saga_maestro.modules.saga.SagaStepExecutionType;
import com.github.khalifagad.saga_maestro.modules.saga.SagaStepOnFailureOption;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateSagaStepDto {
    @Valid
    private SagaStepExecutionType executionType;

    @Valid
    private SagaStepOnFailureOption onFailureAction;

    @NotBlank
    @Size(min = 24, max = 24, message = "Invalid endpoint ID")
    private String endpointId;

    @Nullable
    @Size(min = 24, max = 24, message = "Invalid endpoint ID")
    private String rollbackEndpointId;
}
