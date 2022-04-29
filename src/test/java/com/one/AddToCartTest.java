package com.one;

import static org.testng.Assert.assertTrue;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.one.framework.Browser;
import com.one.framework.WebDriverConfig;
import com.one.ui.pages.AddToCart;
import com.one.ui.pages.LoginForm;

@ContextConfiguration(classes = { LoginForm.class, AddToCart.class, WebDriverConfig.class, Browser.class })
public class AddToCartTest extends AbstractTestNGSpringContextTests {
    
	@Autowired
	private LoginForm loginForm;

    @Inject
    private Browser browser;
    private AddToCart addToCart;
    
	@Test
	public void checkoutProcess() {
		
		assertTrue(addToCart.isAddToCartVisible(), "Add to cart button is not displayed");
		addToCart.clickProductAddToCart();
		assertTrue(addToCart.isShoppingCartVisible(), "Shopping cart is not visible");
		addToCart.clickShoppingCart();
		assertTrue(addToCart.isCheckoutVisible(),"Checkout button is not visible");
		addToCart.clickCheckout();
		addToCart.enterFirstName();
		addToCart.enterLastName();
		addToCart.enterPostal();
		addToCart.clickContinue();
		addToCart.clickFinish();
		
	}
	
	@BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void beforeTestMethod(String username, String password) {
		addToCart = new AddToCart(browser);
        loginForm.loginAs(username, password);
    }

}
