package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    /**
     * This function will execute before each Test tag in testng.xml
     * @param browser
     * @throws Exception
     */

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) throws Exception {

        //Check if parameter passed from TestNG is 'chrome'
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
            driver = new ChromeDriver();
        }
        //Check if parameter passed is 'remote'
        else if (browser.equalsIgnoreCase("remote")) {
            // Running on Selenium Grid
            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setBrowserName("chrome");
            ChromeOptions options = new ChromeOptions();
            options.merge(capability);
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        }
        else{
            //If no browser is passed throw exception
            throw new Exception("Incorrect Browser");
        }

        //Launch URL
        driver.get("https://www.amazon.in/");
        // maximize the window
        driver.manage().window().maximize();
        // get page title
        System.out.println(driver.getTitle());
        // To make the page wait until the URL fully loads to avoid our test from Failing, add a global wait time.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
