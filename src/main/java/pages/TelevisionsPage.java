package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelevisionsPage {

    private WebDriver driver;

    public TelevisionsPage(WebDriver driver){
        this.driver = driver;
    }

    private By brandSamsung = By.linkText("Samsung");

    public SamsungPage clickSamsung(){
        driver.findElement(brandSamsung).click();
        return new SamsungPage(driver);
    }

}
