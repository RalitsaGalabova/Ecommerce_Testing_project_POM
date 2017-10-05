//********************************************************************************************                                                                               *
//*    Guru99 eCommerce Live Project                                                         *
//*    Day 4 - TestCase 4                                                                    *
//*    Author: Ralitsa Galabova                                                              *                                                                                      *
//********************************************************************************************

/*
Test Steps:
1. Goto http://live.guru99.com/
2. Click on ‘MOBILE’ menu
3. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Sony Xperia & Iphone)
4. Click on ‘COMPARE’ button. A popup window opens
5. Verify the pop-up window and check that the products are reflected in it
   Heading "COMPARE PRODUCTS" with selected products in it.
6. Close the Popup Windows
*/

package testCases;

import org.junit.Test;
import pages.BasePage;
import pages.HomePage;
import pages.MobilePage;
import pages.PopUpCompareProducts;

public class CompareProducts extends BasePageTests {
	
	@Test
	public void compareTwoProducts(){
		HomePage homePage = new HomePage(driver);
		MobilePage mobilePage = new MobilePage(driver);
		BasePage base = new BasePage(driver);
		PopUpCompareProducts compare = new PopUpCompareProducts(driver);
		
		homePage.clickOnMobile();
		mobilePage.addToCompareSonyX();
		mobilePage.addToCompareIphone();
		mobilePage.compareProducts();
		base.switchWindows();
		compare.verifyPopUpTitle("COMPARE PRODUCTS");
		compare.verifyComparedProducts("SONY XPERIA", "IPHONE");
		
	}

}
