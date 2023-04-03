package com.simplilearn.capstoneproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpAdressPage {
	
	WebDriverWait wait;
	
	@FindBy(id = "addressLineOne")
	private WebElement addressLineOne;
	@FindBy(id = "addressLineTwo")
	private WebElement addressLineTwo;
	@FindBy(id = "city")
	private WebElement city;
	@FindBy(id = "postalCode")
	private WebElement postalCode;
	@FindBy(id = "state")
	private WebElement state;
	@FindBy(id = "country")
	private WebElement country;
	// _eventId_confirm
	@FindBy(xpath = "//button[contains(@name, '_eventId_confirm')]")  
	private WebElement btnSubmitConfirm;
	
	public SignUpAdressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	public void enterAddressLineOne(String strAddressOne) {
		wait.until(ExpectedConditions.visibilityOf(addressLineOne));
		addressLineOne.sendKeys(strAddressOne);
	}
	public void enterAddressLineTwo(String strAddressTwo) {
		addressLineTwo.sendKeys(strAddressTwo);
	}
	public void enterCity(String strCity) {
		city.sendKeys(strCity);
	}
	public void enterPostalCode(String strPostalCode) {
		postalCode.sendKeys(strPostalCode);
	}
	public void enterState(String strState) {
		state.sendKeys(strState);
	}
	public void enterCountry(String strCountry) {
		country.sendKeys(strCountry);
	}
	
	public void clickSubmitConfirm() {
		btnSubmitConfirm.click();
	}
}
