package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/B_Flight_Depatures.feature",
glue="org.stepdefinition/FlightDepatureReturn.class",
monochrome=true,
dryRun=true, strict=true)
public class DryRunner {

}
