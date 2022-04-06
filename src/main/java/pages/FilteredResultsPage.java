package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class FilteredResultsPage {

    private WebDriver driver;

    private By secondHighestItem = By.cssSelector(".sg-col-4-of-12:nth-child(3)");


    public FilteredResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public ItemPage clickSecondHighestItem(){
        driver.findElement(secondHighestItem).click();

        //Switch to the new window
        String parent=driver.getWindowHandle();
        Set<String> handles=driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> it= handles.iterator();
        while(it.hasNext()) {
            {
                String child_window=it.next();
                if(!parent.equals(child_window))
                {
                    driver.switchTo().window(child_window);
                    System.out.println(driver.switchTo().window(child_window).getTitle());
                }
            }
        }
        return new ItemPage(driver);
    }

}
