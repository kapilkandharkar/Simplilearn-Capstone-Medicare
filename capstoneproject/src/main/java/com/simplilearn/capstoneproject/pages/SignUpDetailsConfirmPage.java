package com.simplilearn.capstoneproject.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpDetailsConfirmPage {
	
	WebDriverWait wait;
	
	@FindBy(xpath = "//a[contains(@href, 'personal')]")  
	private WebElement btnPersonalEdit;
	
	@FindBy(xpath = "//a[contains(@href, 'billing')]")  
	private WebElement btnBillingEdit;
	
	@FindBy(xpath = "//a[contains(@class,'btn btn-lg btn-primary')]")  
	private WebElement btnConfirmEdit;

	public SignUpDetailsConfirmPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
    public void verifySignUpPersonalDetails(String firstName, String lastName, String email, String contactNumber) {
    	wait.until(ExpectedConditions.elementToBeClickable(btnConfirmEdit));
    	WebElement panelPersonalDetails = btnPersonalEdit.findElement(By.xpath("./..")).findElement(By.xpath("./.."));
    	
    	assertTrue(panelPersonalDetails.getText().contains(firstName));
    	assertTrue(panelPersonalDetails.getText().contains(lastName));
    	assertTrue(panelPersonalDetails.getText().contains(email));
    	assertTrue(panelPersonalDetails.getText().contains(contactNumber));

    	//System.out.println(panelPersonalDetails.getText());

    }
    
    public void verifySignUpBillingDetails(String addressOne, String addressTwo, String city, String postalCode, String state, String country) {
    	wait.until(ExpectedConditions.elementToBeClickable(btnConfirmEdit));
    	WebElement panelBillingDetails = btnBillingEdit.findElement(By.xpath("./..")).findElement(By.xpath("./.."));
    	
    	assertTrue(panelBillingDetails.getText().contains(addressOne));
    	assertTrue(panelBillingDetails.getText().contains(addressTwo));
    	assertTrue(panelBillingDetails.getText().contains(city));
    	assertTrue(panelBillingDetails.getText().contains(postalCode));
    	assertTrue(panelBillingDetails.getText().contains(state));
    	assertTrue(panelBillingDetails.getText().contains(country));
    	
    	//System.out.println(panelBillingDetails.getText());

    }
    
    public void clickConfirm() {
    	btnConfirmEdit.click();
	}
	

}
