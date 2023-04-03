package com.simplilearn.capstoneproject.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriverWait wait;

	@FindBy(xpath = "//li[contains(@id, 'userModel')]")
	private WebElement userModel;

	@FindBy(xpath = "//a[contains(@href, '/medicare/cart/show')]")
	private WebElement cartShow;

	@FindBy(xpath = "//ul[contains(@class, 'dropdown-menu')]")
	private WebElement userDropDownMenu;

	@FindBy(xpath = "//a[contains(@href, '/medicare/show/all/products')]")
	private WebElement btnViewProducts;

	@FindBy(id = "productListTable")
	private WebElement productListTable;

	@FindBy(xpath = "//a[contains(@href, '/medicare/cart/add/1/product')]")
	private WebElement firstProduct;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 1000);
	}

	public void verifyLoginForUser(String strFirstName, String strLastName) {
		wait.until(ExpectedConditions.elementToBeClickable(userModel));
		assertEquals(userModel.getText(), strFirstName + " " + strLastName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userModel.click();
		wait.until(ExpectedConditions.elementToBeClickable(cartShow));
		assertTrue(cartShow.getText().contains("₹"));
	}

	public void verifyLoginForSupplier(String strFirstName, String strLastName) {
		wait.until(ExpectedConditions.elementToBeClickable(userModel));
		assertEquals(userModel.getText(), strFirstName + " " + strLastName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userModel.click();
		wait.until(ExpectedConditions.elementToBeClickable(userDropDownMenu));
		assertEquals(userDropDownMenu.getAttribute("childElementCount").toString(), "1");
	}

	public void clickViewProducts() {
		wait.until(ExpectedConditions.elementToBeClickable(btnViewProducts));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnViewProducts.click();
	}

	public void addFirstProductToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
		WebElement firstRow = firstProduct.findElement(By.xpath("./..")).findElement(By.xpath("./.."));
		System.out.println(firstRow.getText());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		firstProduct.click();

	}

	public void addProductToCartByIndex(int index) {
		wait.until(ExpectedConditions.visibilityOf(productListTable));
		List<WebElement> productRows = productListTable.findElements(By.xpath("//tr[contains(@role, 'row')]"));
		WebElement btnAddToCart = productRows.get(index)
				.findElement(By.xpath("//a[contains(@href, '/medicare/cart/add/" + index + "/product')]"));
		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnAddToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(btnViewProducts));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnViewProducts.click();
		
	}
	
	public void addProductToCartByName(String productName) {
		
		int productIndex = getProductIndexByName(productName);
		addProductToCartByIndex(productIndex);
	
	}
	
	public String getProductPriceByIndex(int index) {
		wait.until(ExpectedConditions.visibilityOf(productListTable));
		List<WebElement> productRows = productListTable.findElements(By.xpath("//tr[contains(@role, 'row')]"));
		List<WebElement> productCols = productRows.get(index).findElements(By.tagName("td"));
		return productCols.get(3).getText();  // 3 is column index for Price
	}
	
	public String getProductPriceByName(String productName) {
		int productIndex = getProductIndexByName(productName);
		String productPrice = getProductPriceByIndex(productIndex);
		System.out.println(productName + " Product Page Price : " + productPrice );
		return productPrice;
	}
	
	public int getProductIndexByName(String productName) {
		
		int productIndex = -1;
		wait.until(ExpectedConditions.visibilityOf(productListTable));
		List<WebElement> productRows = productListTable.findElements(By.xpath("//tr[contains(@role, 'row')]"));
		for(int i=1; i<productRows.size(); i++ ) {
			if(productRows.get(i).getText().contains(productName)) {
				productIndex =i;
				break;
			}
		}
		return productIndex;
		
	}
	
	
}
