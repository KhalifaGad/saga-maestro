package com.github.khalifagad.saga_maestro.modules.saga;

import com.github.khalifagad.saga_maestro.modules.endpoint.Endpoint;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

enum SagaStepExecutionType {
    SEQUENTIAL,
    PARALLEL
}

enum SagaStepOnFailureOption {
    ROLLBACK,
    PASS
}

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SagaStep {
    private String id;

    private SagaStepExecutionType executionType = SagaStepExecutionType.SEQUENTIAL;
    private SagaStepOnFailureOption onFailureAction = SagaStepOnFailureOption.ROLLBACK;

    @DBRef
    private Endpoint endpoint;
    private String endpointId;

    @Nullable
    @DBRef
    private Endpoint rollbackEndpoint;

    @Nullable
    private String rollbackEndpointId;
}
