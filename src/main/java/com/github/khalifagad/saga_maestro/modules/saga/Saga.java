package com.github.khalifagad.saga_maestro.modules.saga;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sagas")
public class Saga {
    private String id;

    @NotBlank
    @Indexed(unique = true)
    private String name;

    @Size(min = 1, message = "At least one step is required")
    private SagaStep[] steps;
}
