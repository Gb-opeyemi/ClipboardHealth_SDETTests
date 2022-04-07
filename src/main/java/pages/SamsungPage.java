package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SamsungPage {

    private WebDriver driver;

    private By filterResultsDropdown = By.id("a-autoid-0-announce");
    private By filterFromHighToLow = By.id("s-result-sort-select_2");

    public SamsungPage(WebDriver driver){
        this.driver = driver;
    }

    // Method to click on Filter button to show dropdown
    public void clickFilterResultsDropdown(){
        clickElement(filterResultsDropdown);
    }

    // Method to click on High to Low from dropdown
    public FilteredResultsPage clickFilterFromHighToLow(){
        clickElement(filterFromHighToLow);
        return new FilteredResultsPage(driver);
    }


    //Helper Method to click on elements
    private void clickElement(By element){
        driver.findElement(element).click();
    }
}
