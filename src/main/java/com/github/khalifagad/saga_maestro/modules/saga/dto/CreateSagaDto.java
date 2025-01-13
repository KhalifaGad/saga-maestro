package com.github.khalifagad.saga_maestro.modules.saga.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateSagaDto {
    @NotBlank
    private String name;

    @Valid
    @Size(min = 1)
    private CreateSagaStepDto[] steps;
}
