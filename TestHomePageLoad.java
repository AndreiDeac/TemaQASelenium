import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HomePageTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testHomePageLoad() {
        // Navigate to the home page
        driver.get("https://magento.softwaretestingboard.com");

        // Check if the title contains the expected text
        String expectedTitle = "Expected Title"; // Replace with actual title
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
