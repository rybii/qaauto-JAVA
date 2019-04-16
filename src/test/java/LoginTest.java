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
        WebElement loginEmail = driver.findElement(By.xpath("//input[@id='login-email']"));
        loginEmail.sendKeys("semencement2@gmail.com");
        WebElement loginPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        loginPassword.sendKeys("Semen1002");
        WebElement loginSubmit = driver.findElement(By.xpath("//input[@id='login-submit']"));
        loginSubmit.click();
        Assert.assertEquals(driver.getTitle(), "LinkedIn");

    }
}
