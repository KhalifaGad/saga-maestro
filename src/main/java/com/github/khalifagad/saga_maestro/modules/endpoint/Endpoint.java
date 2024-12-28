package com.github.khalifagad.saga_maestro.modules.endpoint;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "endpoints")
public class Endpoint {
    @Id
    private String id;

    private String name;

    @NotBlank
    @Indexed(unique = true)
    private String url;

    @NotBlank
    private EndpointMethod method;

    private String actorId;

    private Object headers;

    private int maxRetries = 0;
}
