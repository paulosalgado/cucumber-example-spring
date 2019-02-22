package com.example.demo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty" },
        features = { "classpath:features/calculator.feature" },
        glue = { "com.example.demo.step" })
public class DemoApplicationTests {

}
