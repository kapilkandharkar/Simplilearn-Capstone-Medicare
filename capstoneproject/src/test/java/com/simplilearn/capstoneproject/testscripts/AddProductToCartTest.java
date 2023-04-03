package com.simplilearn.capstoneproject.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.simplilearn.capstoneproject.pages.*;

public class AddProductToCartTest extends BaseTest {
	
	String firstName = "Sherlock";
	String lastName = "Holmes";
	String email = "sherlock.user@holmes2.com";
	String password = "elementary";

	@Test
	public void addProductCartTest() {
		
		String poductName = "Diclofenac";
		String poductName2 = "Combiflame";
		String prodPrice = "";
		String prodPrice2 = "";
		String prodCartPrice = "";
		String prodCartPrice2 = "";
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickLogin();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		
		CartShowPage cartShowPageEmpty = new CartShowPage(driver);
		cartShowPageEmpty.emptyCart();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickViewProducts();
		homePage.addProductToCartByName(poductName);
		prodPrice = homePage.getProductPriceByName(poductName);
		homePage.addProductToCartByName(poductName2);
		prodPrice2 = homePage.getProductPriceByName(poductName2);
		
		
		CartShowPage cartShowPage = new CartShowPage(driver);
		cartShowPage.showCart();
		prodCartPrice = cartShowPage.getCartPriceForProduct(poductName);
		prodCartPrice2 = cartShowPage.getCartPriceForProduct(poductName2);
		
		assertTrue(prodCartPrice.contains(prodPrice));
		assertTrue(prodCartPrice2.contains(prodPrice2));
		
	}

}
