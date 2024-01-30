import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NewsletterSubscriptionTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testNewsletterSubscription() {
        // Log in to the user's account
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        driver.findElement(By.id("email")).sendKeys("user_email@example.com"); // Replace with actual email
        driver.findElement(By.id("pass")).sendKeys("user_password"); // Replace with actual password
        driver.findElement(By.id("send2")).click();

        // Navigate to the newsletter subscription section
        // The actual navigation will depend on how the website is structured
        driver.get("https://magento.softwaretestingboard.com/newsletter/manage/");

        // Subscribe to the newsletter
        if (!driver.findElement(By.id("subscription")).isSelected()) {
            driver.findElement(By.id("subscription")).click();
        }
        driver.findElement(By.cssSelector("button[title='Save']")).click();

        // Verify subscription success
        WebElement successMessage = driver.findElement(By.cssSelector(".message-success"));
        Assert.assertTrue(successMessage.isDisplayed());

        // Unsubscribe from the newsletter
        if (driver.findElement(By.id("subscription")).isSelected()) {
            driver.findElement(By.id("subscription")).click();
        }
        driver.findElement(By.cssSelector("button[title='Save']")).click();

        // Verify unsubscription success
        WebElement successUnsubscribeMessage = driver.findElement(By.cssSelector(".message-success"));
        Assert.assertTrue(successUnsubscribeMessage.isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
