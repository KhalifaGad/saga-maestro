package com.github.khalifagad.saga_maestro.modules.actor.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class CreateActorDto {
    @NotBlank
    private String name;

    @URL
    @NotBlank
    private String baseUrl;

    private Object headers;

    @Min(0)
    private int endpointsMaxRetries;
}
