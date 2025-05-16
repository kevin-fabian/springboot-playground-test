package com.fabiankevin.app.listeners;

import com.fabiankevin.app.models.PlanetEvent;
import com.fabiankevin.app.service.PlanetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PlanetListeners {
    private final PlanetService planetService;

    @KafkaListener(topics = "super-planets")
    public void planetListener(PlanetEvent planetEvent) {
        log.info("Planet received {}", planetEvent);
        planetService.processPlanet(planetEvent);
    }
}
