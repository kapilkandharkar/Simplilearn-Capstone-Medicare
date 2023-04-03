package com.simplilearn.capstoneproject.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpWelcomePage {

	WebDriverWait wait;

	@FindBy(xpath = "//h6")  
	private WebElement welcomeMsg;
	
	public SignUpWelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 1000);
	}
	
	public void verifyWelcomeMessage() {
		wait.until(ExpectedConditions.visibilityOf(welcomeMsg));
		System.out.println(welcomeMsg.getText());
		assertTrue(welcomeMsg.getText().contains("You can use your email address as username to login!"));
	}

}
