import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddToCartTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testAddToCart() {
        // Navigate to a specific product listing page
        driver.get("https://magento.softwaretestingboard.com/some-category");

        // Click on a specific product
        WebElement product = driver.findElement(By.cssSelector(".product-item-link"));
        product.click();

        // Add the product to the cart
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[title='Add to Cart']"));
        addToCartButton.click();

        // Verify that the product has been added to the cart
        // This verification might depend on how the site indicates a successful addition (e.g., a cart icon with a number, a message, etc.)
        WebElement cartIndicator = driver.findElement(By.cssSelector(".cart-count"));
        Assert.assertTrue(cartIndicator.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
