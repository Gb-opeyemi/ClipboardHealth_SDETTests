package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {

    private WebDriver driver;

    private By aboutItemSection = By.id("feature-bullets");

    public ItemPage(WebDriver driver){
        this.driver = driver;
    }


    public boolean assertAboutItemSection(){
      return driver.findElement(aboutItemSection).isDisplayed();
    }

    public void getAboutItemSectionText(){
        System.out.println(driver.findElement(aboutItemSection).getText());
    }

}
