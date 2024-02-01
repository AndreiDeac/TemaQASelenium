import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmptyCartCheckoutTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = a new ChromeDriver();
    }

    @Test
    public void testEmptyCartCheckout() {
        // Navigate to the cart page
        driver.get("https://magento.softwaretestingboard.com/checkout/cart/");

        // Verify that the cart is empty
        WebElement emptyCartMessage = driver.findElement(By.cssSelector(".cart-empty"));
        Assert.assertTrue(emptyCartMessage.isDisplayed());

        // Attempt to proceed to checkout
        WebElement checkoutButton = driver.findElement(By.cssSelector("button[title='Proceed to Checkout']"));
        checkoutButton.click();

        // Verify the behavior - depends on the website's functionality
        // Here, we're checking if the checkout button does not lead to a new page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout/cart"));
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
