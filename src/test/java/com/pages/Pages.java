package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Pages {
	WebDriver driver;
	public Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Login")
	public WebElement lnkLogin;
	
	@FindBy(xpath="//ul[@role='tablist']/li[text()='Login']")
	public WebElement loginTab;
	
	@FindBy(xpath="//ul[@role='tablist']/li[text()='Create Account']")
	public WebElement createAccountTab;
	
	@FindBy(id="firstName")
	public WebElement txtName;
	
	@FindBy(id="email")
	public WebElement txtEmail;
	
	@FindBys(@FindBy(id="phoneNumber"))
	public List<WebElement> txtPhoneNumber;
	
	@FindBy(id="password")
	public WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement btnSubmit;
	
	
	@FindBy(xpath="//button[text()='Forgot password?']")
	public WebElement btnLoginForgetPwd;

	@FindBy(id="postCode")
	public WebElement txtPostCode;
	
	public WebElement getAccount(String linkText) {
		return driver.findElement(By.linkText(linkText));	
	}
	
}
