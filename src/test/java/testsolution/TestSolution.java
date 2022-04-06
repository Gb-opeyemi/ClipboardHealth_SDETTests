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
        homePage.clickHamburgerMenu();
        homePage.clickTvAndElectronics();
        TelevisionsPage televisionsPage = homePage.clickTelevisions();
        SamsungPage samsungPage = televisionsPage.clickSamsung();
        samsungPage.clickFilterResultsDropdown();
        FilteredResultsPage filteredResultsPage = samsungPage.clickFilterFromHighToLow();
        ItemPage itemPage = filteredResultsPage.clickSecondHighestItem();
        assertEquals(true, itemPage.assertAboutItemSection());
        itemPage.getAboutItemSectionText();
    }

}
