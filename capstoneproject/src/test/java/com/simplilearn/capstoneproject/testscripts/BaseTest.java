package com.simplilearn.capstoneproject.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.simplilearn.capstoneproject.pages.SignUpAdressPage;
import com.simplilearn.capstoneproject.pages.SignUpDetailsConfirmPage;
import com.simplilearn.capstoneproject.pages.SignUpPage;

public class BaseTest {
	
	WebDriver driver;

	@BeforeTest
	public void launchApplication() {

		System.setProperty("webdriver.chrome.driver", "resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/medicare/");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	public void enterPersonalDetailsSignUp(String firstName, String lastName, String email, String contactNumber,
			String password, String role) {

		SignUpPage signupPage = new SignUpPage(driver);

		signupPage.enterFirstName(firstName);
		signupPage.enterLastName(lastName);
		signupPage.enterEmail(email);
		signupPage.enterContact(contactNumber);
		signupPage.enterPassword(password);
		signupPage.enterConfirmPassword(password);
		signupPage.selectRole(role);
		signupPage.clickSubmit();
	}

	public void enterBillingDetailsSignUp(String addressOne, String addressTwo, String city, String postalCode,
			String state, String country) {

		SignUpAdressPage signupAdressPage = new SignUpAdressPage(driver);
		signupAdressPage.enterAddressLineOne(addressOne);
		signupAdressPage.enterAddressLineTwo(addressTwo);
		signupAdressPage.enterCity(city);
		signupAdressPage.enterPostalCode(postalCode);
		signupAdressPage.enterState(state);
		signupAdressPage.enterCountry(country);
		signupAdressPage.clickSubmitConfirm();
	}
	
	public void confirmDetailsOnSignUp(String firstName, String lastName, String email, String contactNumber,
			String password, String addressOne, String addressTwo, String city, String postalCode,
			String state, String country) {
		
		SignUpDetailsConfirmPage signupDetailsConfirmPage = new SignUpDetailsConfirmPage(driver);
		signupDetailsConfirmPage.verifySignUpPersonalDetails(firstName, lastName, email, contactNumber);
		signupDetailsConfirmPage.verifySignUpBillingDetails(addressOne, addressTwo, city, postalCode, state, country);
		signupDetailsConfirmPage.clickConfirm();
	}

}
