package fita.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"featuresBDD"},
glue= {"stepDefinitions"},tags= "@parameterization",plugin= {"pretty","html:target/htmlreports.html"})
public class Runner extends AbstractTestNGCucumberTests{

	
}
