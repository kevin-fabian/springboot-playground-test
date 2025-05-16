package com.fabiankevin.app;

import com.fabiankevin.app.service.PlanetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class AppApplicationTests {
    @Autowired
    private PlanetService planetService;

    @Test
    void contextLoads1() {
        assertDoesNotThrow(() -> {
            planetService.processPlanet(null);
        });
    }

    @Test
    void contextLoads2() {
        assertDoesNotThrow(() -> {
            planetService.processPlanet(null);
        });
    }


}
