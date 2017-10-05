//********************************************************************************************                                                                               *
//*    Guru99 eCommerce Live Project                                                         *
//*    Day 1 - TestCase 1                                                                    *
//*    Author: Ralitsa Galabova                                                              *                                                                                      *
//********************************************************************************************


/*  
Test Steps
Step 1. Goto http://live.guru99.com/
Step 2. Verify Title of the page
Step 3. Click on ‘MOBILE’ menu
Step 4. Verify Title of the page
Step 5. In the list of all mobile , select ‘SORT BY’ dropdown as ‘name’
Step 6. Verify all products are sorted by name
*/


package testCases;

import org.junit.Test;
import pages.HomePage;
import pages.MobilePage;

public class VerifyMobileListIsSortedByName extends BasePageTests {
	
	@Test
	public void verifyMobileListIsSortedByName(){
		HomePage homePage = new HomePage(driver);
		homePage.verifyTitle("THIS IS DEMO SITE FOR   ");
		homePage.clickOnMobile();
		MobilePage mobilePage = new MobilePage(driver);
		mobilePage.verifyTitle("MOBILE");
		mobilePage.selectDropDownBy("Name");
		mobilePage.assertIsSortedByName();
		
	}
}
