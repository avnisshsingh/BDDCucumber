package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/features/vendorSearch.feature", glue = "com.stepDefinitions", plugin = {
		"pretty", "html:target/cucumber-report.html" }, monochrome = false)

public class VendorSearchRunner extends AbstractTestNGCucumberTests {

}
