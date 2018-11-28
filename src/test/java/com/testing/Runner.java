package com.testing;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features=".",
        tags = {"@register"}

        )
public class Runner {
}
