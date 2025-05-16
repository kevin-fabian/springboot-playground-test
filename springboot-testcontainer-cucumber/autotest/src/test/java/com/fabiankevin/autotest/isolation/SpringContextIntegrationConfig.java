package com.fabiankevin.autotest.isolation;

import com.fabiankevin.app.AppApplication;
import com.fabiankevin.app.service.PlanetService;
import com.fabiankevin.autotest.TestSpringbootTestcontainerCucumberApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

@Slf4j
@ActiveProfiles({"test"})
@CucumberContextConfiguration
@SpringBootTest(classes = AppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Import({TestSpringbootTestcontainerCucumberApplication.class})
public class SpringContextIntegrationConfig {

    @Autowired
    @MockitoSpyBean
    private PlanetService planetService;
}