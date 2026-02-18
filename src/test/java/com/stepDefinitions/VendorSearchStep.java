package com.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VendorSearchStep {

	WebDriver driver;

	@Given("User is on bstackdemo.com")
	public void user_is_on_bstackdemo_com() {
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://bstackdemo.com/");
	}

	@When("User chooses {string}")
	public void user_chooses(String vendor) throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='" + vendor + "']")).click();
		Thread.sleep(3000);
	}

	@Then("Products of {string} should show {string}")
	public void products_of_should_show(String vendor, String vendorBrand) {

		String productName = driver.findElement(By.xpath("//p[@class='shelf-item__title']")).getText();
		Assert.assertTrue(productName.contains(vendorBrand));
		System.out.println(productName);
		driver.quit();
	}

}
