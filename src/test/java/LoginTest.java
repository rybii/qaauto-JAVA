import com.sun.xml.internal.bind.v2.TODO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vryb\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");//открыть сайт
        loginPage = new LoginPage(driver); // создать физически в памяти экземпляр класса в переменной
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
            {"semencement2@gmail.com", "Semen1002"},
            //{"SEMENcement2@gmail.com", "Semen1002"}
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        HomePage homePage = loginPage.login(userEmail, userPassword); // передали 2 параметра в классе login
        Assert.assertTrue(homePage.isProfileMenuItemDisplayed(), "Home page is not loaded");
        homePage.clickOnProfileMenu();
        Assert.assertEquals(homePage.getUserNameTextDisplayed(), "Semen Cement");
    }

    @DataProvider
    public Object[][] invalidDataProviderBothFields() {
        return new Object[][]{
            {"", ""},
            {"SEMENcement3@gmail.com", "Semen1003"}
        };
    }

    @Test(dataProvider = "invalidDataProviderBothFields")
    public void negativeLoginTestEmptyFields() {
        loginPage.loginToLogin("", ""); //разобраться почему перед loginPage нету loginPage как в двух других тестах
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page isn't loaded.");
    }

    @DataProvider
    public Object[][] invalidDataProviderLesson() {
        return new Object[][]{
            {"semencement2@gmail.com", "Semen1003", "", "Hmm, that's not the right password. Please try again or request a new one."},
                //{"semencement4@gmail.com", "Semen1002", "Hmm, we don't recognize that email. Please try again.", ""}
        };
    }

    @Test(dataProvider = "invalidDataProviderLesson")
    public void negativeLoginWithInvalidData(String userEmail,
                                             String userPassword,
                                             String userEmailValidationMessage,
                                             String userPasswordValidationMessage) {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page isn't loaded.");
        LoginSubmitPage loginSubmitPage = loginPage.loginSubmitPage(userEmail, userPassword);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "LoginSubmit page is not loaded.");

        Assert.assertEquals(loginSubmitPage.getUserEmailValidationMessage(), userEmailValidationMessage, "Wrong validation message on user email");

        Assert.assertEquals(loginSubmitPage.getUserPasswordValidationMessage(), userPasswordValidationMessage, "Wrong validation message on user email");
    }
}



