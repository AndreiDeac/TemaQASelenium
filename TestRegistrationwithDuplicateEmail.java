import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DuplicateEmailRegistrationTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testDuplicateEmailRegistration() {
        // Navigate to the registration page
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

        // Fill in the registration form using a duplicate email
        driver.findElement(By.id("firstname")).sendKeys("TestFirstName");
        driver.findElement(By.id("lastname")).sendKeys("TestLastName");
        driver.findElement(By.id("email_address")).sendKeys("alreadyused@example.com"); // Use an already registered email
        driver.findElement(By.id("password")).sendKeys("TestPassword123");
        driver.findElement(By.id("password-confirmation")).sendKeys("TestPassword123");

        // Submit the registration form
        driver.findElement(By.cssSelector("button[title='Create an Account']")).click();

        // Verify that an error message is displayed
        WebElement errorMessage = driver.findElement(By.cssSelector(".message-error"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
