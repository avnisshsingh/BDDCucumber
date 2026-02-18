package com.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	static WebDriver driver;

	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(500);
		driver.quit();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
}
