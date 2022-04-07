package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelevisionsPage {

    public WebDriver driver;

    public TelevisionsPage(WebDriver driver){
        this.driver = driver;
    }

    private By brandSamsung = By.linkText("Samsung");


    // Method to click on Samsung to filter results by Brand Samsung
    public SamsungPage clickSamsung(){
        clickElement(brandSamsung);
        return new SamsungPage(driver);
    }

    //Helper Method to click on elements
    private void clickElement(By element){
        driver.findElement(element).click();
    }

}
