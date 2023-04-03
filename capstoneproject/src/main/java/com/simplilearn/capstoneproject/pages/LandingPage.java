package com.simplilearn.capstoneproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	WebDriverWait wait;
	
	@FindBy(linkText = "Sign Up")
	private WebElement signup;
	
	@FindBy(linkText = "Login")
	private WebElement login;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 2000);
	}
	
	public void clickSignup() {
		wait.until(ExpectedConditions.elementToBeClickable(signup));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		signup.click();
		
	}
	
	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(login));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.click();
		
	}

}
