import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ForgotPasswordTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testForgotPassword() {
        // Navigate to the login page
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        // Click on the 'Forgot Your Password?' link
        driver.findElement(By.linkText("Forgot Your Password?")).click();

        // Submit the email address
        driver.findElement(By.id("email_address")).sendKeys("registered_email@example.com");
        driver.findElement(By.cssSelector("button[title='Reset My Password']")).click();

        // Verify that a confirmation message is displayed
        WebElement confirmationMessage = driver.findElement(By.cssSelector(".message-success"));
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
