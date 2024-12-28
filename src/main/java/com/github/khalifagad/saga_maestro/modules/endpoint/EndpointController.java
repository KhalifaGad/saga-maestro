package com.github.khalifagad.saga_maestro.modules.endpoint;

import com.github.khalifagad.saga_maestro.modules.endpoint.dto.CreateEndpointDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EndpointController {
    private final EndpointService endpointService;

    public EndpointController(EndpointService endpointService) {
        this.endpointService = endpointService;
    }

    @PostMapping("/endpoints")
    Mono<Endpoint> create(@Valid @RequestBody CreateEndpointDto payload) {
        return endpointService.create(payload);
    }

    @GetMapping("/endpoints")
    Flux<EndpointWithActor> list() {
        return endpointService.list();
    }
}
