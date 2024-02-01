import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CartUpdateTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testCartUpdate() {
        // Navigate to a product listing page
        driver.get("https://magento.softwaretestingboard.com/some-category");

        // Click on a specific product
        WebElement product = driver.findElement(By.cssSelector(".product-item-link"));
        product.click();

        // Add the product to the cart
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[title='Add to Cart']"));
        addToCartButton.click();

        // Go to the cart page
        driver.get("https://magento.softwaretestingboard.com/checkout/cart/");

        // Update the quantity
        WebElement quantityInput = driver.findElement(By.cssSelector("input.qty"));
        quantityInput.clear();
        quantityInput.sendKeys("2"); // Update the quantity here

        WebElement updateButton = driver.findElement(By.cssSelector("button[title='Update']"));
        updateButton.click();

        // Verify the cart has been updated
        // This might depend on how the site indicates the update (e.g., message, cart total, etc.)
        WebElement updatedQuantity = driver.findElement(By.cssSelector("input.qty[value='2']"));
        Assert.assertTrue(updatedQuantity.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
