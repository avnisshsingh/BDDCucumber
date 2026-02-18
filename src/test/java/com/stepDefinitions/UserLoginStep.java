package com.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginStep {
	WebDriver driver;

	@Given("user is on Login Page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@When("user enters valid login credentials")
	public void user_enters_valid_login_credentials() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Then("user should be redirected to product list page")
	public void user_should_be_redirected_to_product_list_page() throws InterruptedException {
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualURL, expectedURL);
		Thread.sleep(5000);
		driver.quit();
	}

}
