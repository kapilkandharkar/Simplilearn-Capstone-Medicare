package com.simplilearn.capstoneproject.testscripts;
import org.testng.annotations.Test;
import com.simplilearn.capstoneproject.pages.*;

public class SignUpSupplierTest extends BaseTest {

	String firstName = "Sherlock";
	String lastName = "Holmes";
	String emailSupplier = "sherlock.supplier@holmes2.com";
	String contactNumber = "123456789";
	String password = "elementary";
	String roleSupplier = "Supplier";
	String addressOne = "222 B";
	String addressTwo = "Baker's Street";
	String city = "London";
	String postalCode = "431020";
	String state = "Paddington";
	String country = "UK";

	@Test
	public void signUpTestForSupplier() {
			
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickSignup();

		enterPersonalDetailsSignUp(firstName, lastName, emailSupplier, contactNumber, password, roleSupplier);

		enterBillingDetailsSignUp(addressOne, addressTwo, city, postalCode, state, country);

		confirmDetailsOnSignUp(firstName, lastName, emailSupplier, contactNumber, password, 
							  addressOne, addressTwo, city, postalCode, state, country);

		SignUpWelcomePage signupWelcomePage = new SignUpWelcomePage(driver);
		signupWelcomePage.verifyWelcomeMessage();
	}
}
