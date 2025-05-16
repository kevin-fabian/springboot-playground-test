package com.fabiankevin.autotest.isolation;

import com.fabiankevin.app.models.PlanetEvent;
import com.fabiankevin.app.service.PlanetService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Slf4j
public class HealthCheckStepDef {

    @Autowired
    private KafkaTemplate<String, PlanetEvent> kafkaTemplate;

    @Autowired
    private PlanetService planetService;

    private final CountDownLatch latch = new CountDownLatch(1);

    @Given("application is up")
    public void given_application_up() {

    }

    @When("the user publishes a planet named {string}")
    public void the_user_publishes_a_planet(String name) {
        PlanetEvent planetEvent = new PlanetEvent();
        planetEvent.setName(name);
        planetEvent.setId(UUID.randomUUID());
        planetEvent.setWeight(2.3);
        planetEvent.setStatus("ACTIVE");
        kafkaTemplate.send("super-planets", planetEvent);
        log.info("Planet {} has been successfully published.", name);
    }

    @Then("the application must receive")
    public void the_application_must_receive() throws InterruptedException {
        log.info("Waiting for the app to receive the planet");
        latch.await(1, TimeUnit.SECONDS);
        log.info("Done waiting.");
        verify(planetService, times(1)).processPlanet(any());
    }
}
