import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UpdateUserProfileTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testUpdateUserProfile() {
        // Navigate to the login page
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        // Login with valid credentials
        driver.findElement(By.id("email")).sendKeys("your_email@example.com");
        driver.findElement(By.id("pass")).sendKeys("your_password");
        driver.findElement(By.id("send2")).click();

        // Navigate to the account information or profile edit page
        driver.get("https://magento.softwaretestingboard.com/customer/account/edit/");

        // Update some profile information, such as the user's name
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("UpdatedFirstName");
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("UpdatedLastName");

        // Save the changes
        driver.findElement(By.cssSelector("button[title='Save']")).click();

        // Verify that the changes have been saved (depends on the site's implementation)
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
