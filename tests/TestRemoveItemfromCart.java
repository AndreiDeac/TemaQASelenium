import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RemoveItemFromCartTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testRemoveItemFromCart() {
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

        // Remove the item from the cart
        WebElement removeButton = driver.findElement(By.cssSelector("a.action.delete"));
        removeButton.click();

        // Confirm the removal if necessary
        // driver.switchTo().alert().accept(); // Uncomment if there's a confirmation dialog

        // Verify the item has been removed from the cart
        // This might depend on how the site indicates an empty cart (e.g., message, cart icon, etc.)
        WebElement emptyCartMessage = driver.findElement(By.cssSelector(".cart-empty"));
        Assert.assertTrue(emptyCartMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
