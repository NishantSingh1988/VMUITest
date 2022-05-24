package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.Pages;
import com.utils.DriverManager;
import com.utils.PropertyReader;
import com.utils.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;
	Pages pages;
	PropertyReader pr = PropertyReader.getInstance();
	WebDriverWait webWait; 
	DriverManager manager;
	
	@Given("Open the chrome browser and launch the application")
	public void open_the_chrome_browser_and_launch_the_application() {
		manager = DriverManager.getInstance();
		driver = manager.getDriver();
	    driver.get(pr.getURL());
	    driver.manage().window().maximize();
	    pages = new Pages(driver);
	    webWait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    webWait.until(ExpectedConditions.elementToBeClickable(pages.lnkLogin));
	}
	
	@When("Navigate to login")
	public void navigate_to_login(){
		pages.lnkLogin.click();
		webWait.until(ExpectedConditions.elementToBeClickable(pages.loginTab));
	}
	
	@When("Select login tab")
	public void select_login_tab(){
		pages.loginTab.click();
		webWait.until(ExpectedConditions.elementToBeClickable(pages.btnLoginForgetPwd));
	}
	
	@When("Select account tab")
	public void select_account_tab(){
		pages.createAccountTab.click();
		webWait.until(ExpectedConditions.elementToBeClickable(pages.txtName));
	}
	
	@When("Enter the {string} and {string}")
	public void enter_the_email_and_password(String email, String password) {
	    pages.txtEmail.sendKeys(email);
	    pages.txtPassword.sendKeys(password);
	    webWait.until(ExpectedConditions.elementToBeClickable(pages.btnSubmit));
	}
	@Then("click on submit button")
	public void click_on_submit_button() {
	    pages.btnSubmit.click();
	    webWait.until(ExpectedConditions.elementToBeClickable(pages.txtPostCode));
	}
	@Then("verify {string} user logged in")
	public void verify_user_login(String username) {
		pages.getAccount(username).isDisplayed();
	}
	
	@When("Enter the {string}, {string}, {string} and {string}")
	public void enter_the_name_email_and_password(String name, String email, String phone, String password) {
		if(pages.txtPhoneNumber.size()>0) {
			phone = "981"+Utils.getUUID().substring(0,7);
			pages.txtPhoneNumber.get(0).sendKeys(phone);
		}
		email = email.substring(0, email.indexOf("@"))+Utils.getUUID()+email.substring(email.indexOf("@"));
		pages.txtName.sendKeys(name);
		
		enter_the_email_and_password(email, password);
	}
	
	@Then("verify {string} user registered")
	public void verify_user_registered(String username) {
		pages.getAccount(username).isDisplayed();
		
	}




}
