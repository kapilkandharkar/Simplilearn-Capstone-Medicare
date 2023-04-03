package com.simplilearn.capstoneproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriverWait wait;

	@FindBy(xpath = "//input[contains(@id, 'username')]")
	private WebElement username;
	
	@FindBy(xpath = "//input[contains(@id, 'password')]")
	private WebElement password;
	
	@FindBy(xpath = "//input[contains(@type, 'submit')]")
	private WebElement btnLogin;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 1000);
	}
	
	public void enterUsername(String strUsername) {
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys(strUsername);		
	}
	
	public void enterPassword(String strPassword) {
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(strPassword);		
	}
	
	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnLogin.click();
		
	}
}
