import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MobileResponsivenessTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();

        // Set the browser window size to a typical mobile dimension, e.g., 375x667 for iPhone 6/7/8
        driver.manage().window().setSize(new Dimension(375, 667));
    }

    @Test
    public void testMobileLayout() {
        // Navigate to the website
        driver.get("https://magento.softwaretestingboard.com");

        // Perform tests specific to mobile layout
        // Example: Check for the presence of a mobile menu button
        WebElement menuButton = driver.findElement(By.cssSelector("button.menu-toggle")); // Update selector as needed
        Assert.assertTrue(menuButton.isDisplayed());

        // Additional checks can be made here, such as visibility of elements, layout changes, etc.
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
