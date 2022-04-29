package com.one.ui.pages;

import static com.one.locators.XPathSelector.PRODUCT_ADD_TO_CART;
import static com.one.locators.ClassName.SHOPPING_CART;
import static com.one.locators.Id.CHECKOUT;
import static com.one.locators.Id.FIRST_NAME;
import static com.one.locators.Id.LAST_NAME;
import static com.one.locators.Id.POSTAL;
import static com.one.locators.Id.CONTINUE;
import static com.one.locators.Id.FINISH;

import com.one.framework.Browser;

public class AddToCart {
	private Browser browser;

	public AddToCart(Browser browser) {
		this.browser = browser;
	}

	public boolean isAddToCartVisible() {
		return browser.elementIsDisplayed(PRODUCT_ADD_TO_CART);
	}

	public void clickProductAddToCart() {
		browser.click(PRODUCT_ADD_TO_CART);
	}

	public boolean isShoppingCartVisible() {
		return browser.elementIsDisplayed(SHOPPING_CART);
	}

	public void clickShoppingCart() {
		browser.click(SHOPPING_CART);
	}

	public boolean isCheckoutVisible() {
		return browser.elementIsDisplayed(CHECKOUT);
	}

	public void clickCheckout() {
		browser.click(CHECKOUT);
	}
	public void enterFirstName() {
		browser.await(FIRST_NAME).sendKeys("john");
	}
	public void enterLastName() {
		browser.await(LAST_NAME).sendKeys("doe");
	}
	public void enterPostal() {
		browser.await(POSTAL).sendKeys("1234");
	}
	public void clickContinue() {
		browser.click(CONTINUE);
	}
	public void clickFinish() {
		browser.click(FINISH);
	}
}
