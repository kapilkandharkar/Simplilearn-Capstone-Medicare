package com.simplilearn.capstoneproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
	
	WebDriverWait wait;
	
	@FindBy(id = "firstName")
	private WebElement firstName;
	@FindBy(id = "lastName")
	private WebElement lastName;
	@FindBy(id = "email")
	private WebElement email;
	@FindBy(id = "contactNumber")
	private WebElement contactNumber;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "confirmPassword")
	private WebElement confirmPassword;
	@FindBy(xpath = "//button[contains(@type, 'submit')]")  //// //button[contains(@type, 'submit')]
	private WebElement btnSubmit;		
	@FindBy(id = "role1")
	private WebElement rbtnUser; // role1 User
	@FindBy(id = "role2")
	private WebElement rbtnSupplier; // role2 Supplier
	
	

	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	public void enterFirstName(String strFirstName ) {
		wait.until(ExpectedConditions.visibilityOf(firstName));
		firstName.sendKeys(strFirstName);
	}
	public void enterLastName(String strLastName) {
		lastName.sendKeys(strLastName);
	}
	public void enterEmail(String strEmail) {
		email.sendKeys(strEmail);
	}
	public void enterContact(String strContactNumber) {
		contactNumber.sendKeys(strContactNumber);
	}
	public void enterPassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	public void enterConfirmPassword(String strConfirmPassword) {
		confirmPassword.sendKeys(strConfirmPassword);
	}
	public void clickSubmit() {
		btnSubmit.click();
	}	
	public void selectRole(String roleName) {
		if(roleName=="User") {
			rbtnUser.click();
		}
		if(roleName=="Supplier") {
			rbtnSupplier.click();
		}
			
		
	}

}
