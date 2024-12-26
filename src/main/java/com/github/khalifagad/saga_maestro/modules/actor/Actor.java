package com.github.khalifagad.saga_maestro.modules.actor;

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
@Document(collection = "actors")
public class Actor {
    @Id
    private String id;

    @NotBlank
    @Indexed(unique = true)
    private String name;

    @NotBlank
    @Indexed(unique = true)
    private String baseUrl;

    private Object headers;

    private int endpointsMaxRetries = 0;
}
