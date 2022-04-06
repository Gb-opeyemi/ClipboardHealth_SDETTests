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

    public void clickFilterResultsDropdown(){
        driver.findElement(filterResultsDropdown).click();
    }

    public FilteredResultsPage clickFilterFromHighToLow(){
        driver.findElement(filterFromHighToLow).click();
        return new FilteredResultsPage(driver);
    }

}
