package com.catalinacercel.runner;

import com.catalinacercel.apiModels.Network;
import com.catalinacercel.apiModels.Networks;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        features = "src/test/resources/features/",
        glue = "com/catalinacercel/step_def/",
        dryRun = false,
        tags = {"@NetworkApi"}
)
public class Runner {





}