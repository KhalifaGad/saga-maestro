package com.github.khalifagad.saga_maestro.modules.saga;

import com.github.khalifagad.saga_maestro.modules.saga.dto.CreateSagaDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SagaController {
    private final SagaService sagaService;

    public SagaController(SagaService sagaService) {
        this.sagaService = sagaService;
    }

    @PostMapping("/sagas")
    public Mono<Saga> create(@Valid @RequestBody CreateSagaDto payload) {
        return sagaService.create(payload);
    }

    @GetMapping("/sagas")
    public Flux<SagaWithFullSteps> list() {
        return sagaService.list();
    }
}
