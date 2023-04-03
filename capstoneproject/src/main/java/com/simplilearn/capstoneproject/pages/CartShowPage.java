package com.simplilearn.capstoneproject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartShowPage {

	WebDriverWait wait;

	@FindBy(xpath = "//table[contains(@id, 'cart')]")
	private WebElement cartTable;

	@FindBy(xpath = "//li[contains(@id, 'userModel')]")
	private WebElement userModel;

	@FindBy(xpath = "//a[contains(@href, '/medicare/cart/show')]")
	private WebElement cartShow;

	@FindBy(xpath = "//td[contains(@data-th, 'Price')]")
	private WebElement productPrice;

	@FindBy(xpath = "//a[contains(@href, 'remove')]")
	private WebElement deleteProdFromCart;

	@FindBy(xpath = "//h3[contains(text(), 'Your Cart is Empty!')]")
	private List<WebElement> msgEmptyCart;

	public CartShowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 1000);
	}

	public void showCart() {
		wait.until(ExpectedConditions.elementToBeClickable(userModel));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userModel.click();
		wait.until(ExpectedConditions.elementToBeClickable(cartShow));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cartShow.click();
	}

	public String getCartPriceForProduct(String productName) {
		wait.until(ExpectedConditions.visibilityOf(cartTable));
		String cartPrice = null;
		WebElement cartProductTable = cartTable.findElement(By.tagName("tbody"));
		List<WebElement> productRows = cartProductTable.findElements(By.tagName("tr"));

		for (int i = 0; i < productRows.size(); i++) {

			List<WebElement> productCols = productRows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < productCols.size(); j++) {
				if (!productCols.get(j).getText().isBlank()) {
					if (productCols.get(j).getText().contains(productName)) {
						// 1 is column index for cart price
						System.out.println(productName + " Cart Price : " + productCols.get(1).getText());
						cartPrice =  productCols.get(1).getText();
					}
				}
			}
		}
		return cartPrice;
	}

	public void emptyCart() {

		showCart();

		if (msgEmptyCart.size() == 0) {

			wait.until(ExpectedConditions.visibilityOf(cartTable));

			WebElement cartProductTable = cartTable.findElement(By.tagName("tbody"));
			List<WebElement> productRows = cartProductTable.findElements(By.tagName("tr"));

			for (int i = 0; i < productRows.size(); i++) {
				wait.until(ExpectedConditions.visibilityOf(deleteProdFromCart));

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				deleteProdFromCart.click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
