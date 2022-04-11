package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {

    private WebDriver driver;

    private By aboutItemSection = By.id("feature-bullets");

    public ItemPage(WebDriver driver){
        this.driver = driver;
    }

    // Method to Assert that “About this item” section is present
    public boolean assertAboutItemSection(){
      return driver.findElement(aboutItemSection).isDisplayed();
    }

    // Method to print section text to console
    public String getAboutItemSectionText(){
       return driver.findElement(aboutItemSection).getText();
    }

}
