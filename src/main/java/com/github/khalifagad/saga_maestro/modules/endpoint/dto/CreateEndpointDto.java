package com.github.khalifagad.saga_maestro.modules.endpoint.dto;

import com.github.khalifagad.saga_maestro.modules.endpoint.EndpointMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateEndpointDto {
    @NotBlank
    private String actorId;

    @NotBlank
    private String name;

    @NotBlank
    private String url;

    @NotNull
    @Valid
    private EndpointMethod method;

    private Object headers;

    @Min(0)
    private int maxRetries;
}
