//********************************************************************************************                                                                               *
//*    Guru99 eCommerce Live Project                                                         *
//*    Day 3 - TestCase 3                                                                    *
//*    Author: Ralitsa Galabova                                                              *                                                                                      *
//********************************************************************************************

/*      
Test Steps:
1. Goto http://live.guru99.com/
2. Click on ‘MOBILE’ menu
3. In the list of all mobile , click on ‘ADD TO CART’ for Sony Xperia mobile
4. Change ‘QTY’ value to 1000 and click ‘UPDATE’ button. Expected that an error is displayed 
   "* The maximum quantity allowed for purchase is 500."
5. Verify the error message
6. Then click on ‘EMPTY CART’ link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
7. Verify cart is empty
*/
package testCases;

import org.junit.Test;
import pages.HomePage;
import pages.MobilePage;
import pages.ShoppingCartPage;

public class VerifyProductQuantity extends BasePageTests{
	
	@Test
	public void verifyMaxProductQuantity() {
		HomePage homePage = new HomePage(driver);
		MobilePage mobilePage = new MobilePage(driver);
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		
		homePage.clickOnMobile();
		mobilePage.addToCartSonyExperia();
		cart.changeProductQuantity("1000");
		cart.updateCart();
		cart.verifyErrorMessage("* The maximum quantity allowed for purchase is 500.");
		
		
	}

}
