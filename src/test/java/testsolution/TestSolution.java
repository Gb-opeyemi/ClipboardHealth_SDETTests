package testsolution;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FilteredResultsPage;
import pages.ItemPage;
import pages.SamsungPage;
import pages.TelevisionsPage;

import static org.testng.Assert.assertEquals;

public class TestSolution extends BaseTest {

    @Test
    public void testAmazonSite(){

        // 2. Click on the hamburger menu in the top left corner.
        homePage.clickHamburgerMenu();

        // 3. Then Click on the TV, Appliances and Electronics.
        homePage.clickTvAndElectronics();

        // 4. Then click on Televisions.
        TelevisionsPage televisionsPage = homePage.clickTelevisions();

        // 5. Filter the results by Brand ‘Samsung’
        SamsungPage samsungPage = televisionsPage.clickSamsung();

        // 6a. Click on the Filter button to open the Dropdown
        samsungPage.clickFilterResultsDropdown();

        // 6b. Sort the Samsung results with price High to Low.
        FilteredResultsPage filteredResultsPage = samsungPage.clickFilterFromHighToLow();

        // 7. Click on the second highest priced item and also 8. Switch the Window.
        ItemPage itemPage = filteredResultsPage.clickSecondHighestItem();

        // 9a. Assert that “About this item” section is present
        assertEquals(true, itemPage.assertAboutItemSection());

        // 9b. Log this section text to console/report.
        itemPage.getAboutItemSectionText();
    }

}
