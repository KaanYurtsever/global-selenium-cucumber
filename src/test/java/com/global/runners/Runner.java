package com.global.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},//Type "allure serve" in terminal to get reports of test
        features = "src/test/resources/features/",//path to access feature files
        glue = "com/global/step_definitions",
        tags = "@requestacallback"//scenario name
)

public class Runner {
}
