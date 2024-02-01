import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InvalidSearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testInvalidSearch() {
        // Navigate to the home page
        driver.get("https://magento.softwaretestingboard.com");

        // Enter an invalid search term and submit the search
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("xyznonexistentproduct"); // Use an unlikely search term
        searchBox.submit();

        // Wait for search results to load and check for the no results message
        WebElement noResultsMessage = driver.findElement(By.cssSelector(".message.notice"));
        Assert.assertTrue("No results message not displayed.", noResultsMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
