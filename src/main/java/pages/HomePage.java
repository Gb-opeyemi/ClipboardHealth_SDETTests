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


    // Method to click on Hamburger Menu
    public void clickHamburgerMenu(){
        clickElement(hamburgerMenu);
    }

    // Method to click on TV, Appliances and Electronics.
    public void clickTvAndElectronics(){
        clickElement(tvandelectronics);
    }

    // Method to click on Televisions
    public TelevisionsPage clickTelevisions(){
        clickElement(televisions);
        return new TelevisionsPage(driver);
    }


    //Helper Method to click on elements
    private void clickElement(By element){
        driver.findElement(element).click();
    }
}
