package com.simplilearn.capstoneproject.testscripts;

import org.testng.annotations.Test;

import com.simplilearn.capstoneproject.pages.HomePage;
import com.simplilearn.capstoneproject.pages.LandingPage;
import com.simplilearn.capstoneproject.pages.LoginPage;

public class LoginSupplierTest extends BaseTest {
	
	String firstName = "Sherlock";
	String lastName = "Holmes";
	String email = "sherlock.supplier@holmes2.com";
	String password = "elementary";
	
	@Test
	public void loginTestSupplier() {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickLogin();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		
		HomePage homePage = new HomePage(driver);
		homePage.verifyLoginForSupplier(firstName, lastName);
		
	}
}
