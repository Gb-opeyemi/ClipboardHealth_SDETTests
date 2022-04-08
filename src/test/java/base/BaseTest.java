package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        // If you want to run this test locally on your machine, Uncomment this line
        /*System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();*/

        // Running on Selenium Grid
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
        options.merge(capability);
        driver = new RemoteWebDriver(new URL("http://192.168.8.166:4444"), options);

        //Launch URL
        driver.get("https://www.amazon.in/");
        // maximize the window
        driver.manage().window().maximize();
        // get page title
        System.out.println(driver.getTitle());
        // To make the page wait until the URL fully loads so as to avoid our test from Failing, add a global wait time.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
