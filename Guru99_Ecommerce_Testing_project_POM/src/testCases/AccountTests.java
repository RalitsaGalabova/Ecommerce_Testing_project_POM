//********************************************************************************************                                                                               *
//*    Guru99 eCommerce Live Project                                                         *
//*                                                                                          *
//*    Author: Ralitsa Galabova                                                              *                                                                                      *
//********************************************************************************************

package testCases;

import org.junit.Test;

import pages.AccountDashboard;
import pages.CheckOutPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyOrdersPage;
import pages.MyWishListPage;
import pages.ShoppingCartPage;
import pages.TvPage;

public class AccountTests extends BasePageTests {
	
	@Test
	public void shareWishLists(){
		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		CreateAccountPage acc = new CreateAccountPage(driver);
		TvPage tv = new TvPage(driver);
		MyWishListPage wishList = new MyWishListPage(driver);
		homePage.goToMyAccount();
		login.clickCreateAccont();
		acc.fillForm("Kelyy", "Vanu", "Danu", "ralica_gulubova666@yahoo.com", "123456789", "123456789", false);
		acc.verifyRegistrationIsSuccessful("WELCOME, KELLYY VALNU DANLU!");
		homePage.clickOnTV();
		tv.addLGToWishList();
		wishList.clickShareWishlistButton();
		wishList.enterEmail("rali_slanceto@abv.bg");
		wishList.enterMessage("Hello,test");
		wishList.shareWishlist();
		wishList.verifyShareIsSuccessful();
		}
	
	@Test
	public void purchaseProduct(){
		
		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		CreateAccountPage acc = new CreateAccountPage(driver);
		AccountDashboard dashboard = new AccountDashboard(driver);
		MyWishListPage wishList = new MyWishListPage(driver);
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		CheckOutPage checkout = new CheckOutPage(driver);
		
		homePage.goToMyAccount();
		login.logIn("ralica_gulubova666@yahoo.com", "123456789");
		acc.verifyRegistrationIsSuccessful("WELCOME, KELLYY VALNU DANLU!");
		dashboard.goToWishList();
		wishList.addToCart();
		cart.estimateShoping("United States", "New York", "542896");
		cart.verifyFlatRateisGenerated("$5.00");
		cart.selectFlatRate();
		cart.updatePrice();
		cart.verifyTotalPrice();
		cart.proceedToCheckOut();
		checkout.enterBillingInfo("", "", "", "","ABC", "", "New York", "New York", "542896", "United States", "12345678", "");
		checkout.clickContinue();
		checkout.selectMoneyOrderMethod();
		checkout.clickPlaceOrderButton();
		checkout.verifyOrder();
	}
	
	@Test
	public void reorderProduct(){
		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		AccountDashboard dashboard = new AccountDashboard(driver);
		MyOrdersPage orderPage = new MyOrdersPage(driver);
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		CheckOutPage checkout = new CheckOutPage(driver);
		
		homePage.goToMyAccount();
		login.logIn("ralica_gulubova666@yahoo.com", "123456789");
		dashboard.goToMyOrders();
		orderPage.reorderProduct();
		cart.changeProductQuantity("2");
		cart.updateCart();
		cart.verifyGrandTotalIsUpdated();
		cart.estimateShoping("United States", "New York", "542896");
		cart.verifyFlatRateisGenerated("$10.00");
		cart.selectFlatRate();
		cart.updatePrice();
		cart.verifyTotalPrice();
		cart.proceedToCheckOut();
		checkout.useSameAdres();
		checkout.clickContinue();
		checkout.selectMoneyOrderMethod();
		checkout.clickPlaceOrderButton();
		checkout.verifyOrder();
		
		
	}
}
