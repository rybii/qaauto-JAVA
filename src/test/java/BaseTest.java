import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver; //ToDo: change to private
    protected LoginPage loginPage;

    @Parameters("browserName")
    @BeforeMethod
    public void beforeMethodBrowser(@Optional("chrome") String browserName) throws Exception {
        if (browserName.toLowerCase().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Unsupported 'browserName'");
        }
    }

    @Parameters("browserURL")
    @BeforeMethod
    public void beforeMethodURL (@Optional("en") String browserURL) throws Exception {
        if (browserURL.toLowerCase().equals("de")) {
            driver.get("https://de.linkedin.com/");
            loginPage = new LoginPage(driver);
        } else if (browserURL.toLowerCase().equals("ua")) {
            driver.get("https://ua.linkedin.com/");
            loginPage = new LoginPage(driver);
        } else if (browserURL.toLowerCase().equals("en")) {
            driver.get("https://www.linkedin.com/");
            loginPage = new LoginPage(driver);
        } else {
            throw new Exception("Unsupported 'browserURL'");
        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
