package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By hamburgerMenu = By.id("nav-hamburger-menu");
    private By tvandelectronics = By.linkText("TV, Appliances, Electronics");
    private By televisions = By.linkText("Televisions");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickHamburgerMenu(){
        driver.findElement(hamburgerMenu).click();
    }

    public void clickTvAndElectronics(){
        driver.findElement(tvandelectronics).click();
    }

    public TelevisionsPage clickTelevisions(){
        driver.findElement(televisions).click();
        return new TelevisionsPage(driver);
    }

}
