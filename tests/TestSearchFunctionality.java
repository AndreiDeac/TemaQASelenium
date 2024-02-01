import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testSearchFunctionality() {
        // Navigate to the home page
        driver.get("https://magento.softwaretestingboard.com");

        // Enter a known search term and submit the search
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("known product name"); // Replace with actual product name
        searchBox.submit();

        // Wait for search results to load and check for the presence of results
        // This is a simplistic check; in a real scenario, you might need to check for specific elements or text
        boolean resultsFound = driver.findElements(By.cssSelector(".products-grid .product-item")).size() > 0;
        Assert.assertTrue("No search results found.", resultsFound);
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
