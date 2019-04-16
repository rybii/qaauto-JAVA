import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void successfulLoginTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vryb\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up ");
        WebElement sessionKey = driver.findElement(By.xpath("//input[@name='session_key']"));
        sessionKey.sendKeys("semencement2@gmail.com");
        WebElement sessionPassword = driver.findElement(By.xpath("//input[@name='session_password']"));
        sessionPassword.sendKeys("Semen1002");
        WebElement signIn = driver.findElement(By.xpath("//input[@class='login submit-button']"));
        signIn.click();
        Assert.assertEquals(driver.getTitle(), "LinkedIn");

    }
}
