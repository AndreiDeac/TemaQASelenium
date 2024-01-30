import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogoutTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogout() {
        // Navigate to the login page
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

        // Input valid credentials and login (replace with actual valid credentials)
        driver.findElement(By.id("email")).sendKeys("valid_user@example.com");
        driver.findElement(By.id("pass")).sendKeys("correct_password");
        driver.findElement(By.id("send2")).click();

        // Perform logout action
        // Assuming 'Logout' link is visible after successful login
        driver.findElement(By.linkText("Logout")).click();

        // Check for a successful logout indicator (like presence of 'Login' link)
        WebElement loginLink = driver.findElement(By.linkText("Sign In"));
        Assert.assertTrue(loginLink.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
