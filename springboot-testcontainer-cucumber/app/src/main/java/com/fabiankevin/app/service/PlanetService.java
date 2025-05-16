package com.fabiankevin.app.service;

import com.fabiankevin.app.models.PlanetEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PlanetService {

    public void processPlanet(PlanetEvent event) {
        log.info("Processing planet {}", event);
    }
}
