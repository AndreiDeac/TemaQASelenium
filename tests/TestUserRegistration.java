import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserRegistrationTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testUserRegistration() {
        // Navigate to the registration page
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

        // Fill in the registration form
        driver.findElement(By.id("firstname")).sendKeys("TestFirstName");
        driver.findElement(By.id("lastname")).sendKeys("TestLastName");
        driver.findElement(By.id("email_address")).sendKeys("testuser@example.com"); // Use a unique email
        driver.findElement(By.id("password")).sendKeys("TestPassword123");
        driver.findElement(By.id("password-confirmation")).sendKeys("TestPassword123");

        // Submit the registration form
        driver.findElement(By.cssSelector("button[title='Create an Account']")).click();

        // Verify registration success
        // This could be a confirmation message, redirection to a profile page, etc.
        WebElement successMessage = driver.findElement(By.cssSelector(".message-success"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
