package com.github.khalifagad.saga_maestro.modules.endpoint;

import com.github.khalifagad.saga_maestro.modules.actor.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class EndpointWithActor {
    private Endpoint endpoint;
    private Actor actor;
}
