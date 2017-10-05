//********************************************************************************************                                                                               *
//*    Guru99 eCommerce Live Project                                                         *
//*    Day 2 - TestCase 2                                                                    *
//*    Author: Ralitsa Galabova                                                              *                                                                                      *
//********************************************************************************************

/*
Test Steps:
1. Goto http://live.guru99.com/
2. Click on ‘MOBILE’ menu
3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
4. Click on Sony Xperia mobile
5. Read the Sony Xperia mobile from detail page. Product value in list and details page should be equal ($100). 
*/

package testCases;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.MobilePage;
import pages.SonyExperiaDetailPage;

public class VerifyCostOfProduct extends BasePageTests {
	
	@Test
	public void verifyProductCost(){
		HomePage homePage = new HomePage(driver);
		MobilePage mobilePage = new MobilePage(driver);
		SonyExperiaDetailPage productDetail = new SonyExperiaDetailPage(driver);
		
		homePage.clickOnMobile();
		mobilePage.selectXperia();
		String firstPrice = mobilePage.getXperiaValue();
		String secondPrice = productDetail.getXperiaDetailPagePrice();
		Assert.assertEquals(firstPrice, secondPrice);
		
	}

}
