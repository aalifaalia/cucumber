package org.stepdefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepdefination {
	public WebDriver driver;
	@Given("User Is In Facebook Login Page")
	public void user_Is_In_Facebook_Login_Page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
	}

	@When("Used Invalid Username and Invalid Password")
	public void used_Invalid_Username_and_Invalid_Password() {
		WebElement userId = driver.findElement(By.id("email"));
		userId.sendKeys("riyas");
		WebElement passWd = driver.findElement(By.id("pass"));
		passWd.sendKeys("riyas@123");
	}

	@When("User Click Login button")
	public void user_Click_Login_button() throws InterruptedException {
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		Thread.sleep(3000);
	}

	@Then("User Should be in invalid credentials page")
	public void user_Should_be_in_invalid_credentials_page() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue("check the URL", url.contains("privacy_mutation_token"));
	}

}
