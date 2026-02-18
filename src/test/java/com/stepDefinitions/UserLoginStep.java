package com.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginStep {
	
	WebDriver driver = Hooks.getDriver();
	@Given("user is on Login Page")
	public void user_is_on_login_page() {

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

	}

	@When("User enters Invalid login credentials")
	public void user_enters_invalid_login_credentials() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user1");
		driver.findElement(By.id("password")).sendKeys("secret_sauce1");
		driver.findElement(By.id("login-button")).click();
	}

	@Then("User gets InValid Login error message")
	public void user_gets_in_valid_login_error_message() {
		String expErrorMsg = "Epic sadface: Username and password do not match any user in this service";
		String actErrorMsg = driver.findElement(By.tagName("h3")).getText();
		Assert.assertEquals(expErrorMsg, actErrorMsg);
	
	}

	@When("User try to login without any credentials")
	public void user_try_to_login_without_any_credentials() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("User gets LoginRequired error message")
	public void user_gets_login_required_error_message() {
		String expErrorMsg = "Epic sadface: Username is required";
		String actErrorMsg = driver.findElement(By.tagName("h3")).getText();
		Assert.assertEquals(expErrorMsg, actErrorMsg);

	}

}
