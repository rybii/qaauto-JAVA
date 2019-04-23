import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "semencement2@gmail.com", "Semen1002" },
                { "SEMENcement2@gmail.com", "Semen1002" }
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vryb\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");//открыть сайт
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up ");//проверить этот текст

        LoginPage loginPage = new LoginPage(driver); // создать физически в памяти экземпляр класса в переменной
        loginPage.login(userEmail, userPassword); // передали 2 параметра в классе login


        // loginPage - переменная
        // LoginPage()  - новый класс
        // LoginPage - тип данных


        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProfileMenuItemDisplayed(), "Home page is not loaded");
        homePage.clickOnProfileMenu();
        Assert.assertEquals(homePage.getUserNameTextDisplayed(), "Semen Cement");

        driver.quit();
    }

    @Test
    public void negativeLoginTestEmptyFields() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vryb\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        Assert.assertEquals(driver.getTitle(),"LinkedIn: Log In or Sign Up ");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page isn't loaded.");
        driver.quit();
        }
    }

//    @Test
//    public void negativeLoginTestPassword() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vryb\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.linkedin.com");
//        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up ");
//        WebElement loginEmail = driver.findElement(By.xpath("//input[@id='login-email']"));
//        loginEmail.sendKeys("semencement2@gmail.com");
//        WebElement loginPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
//        loginPassword.sendKeys("Semen1003");
//        WebElement loginSubmit = driver.findElement(By.xpath("//input[@id='login-submit']"));
//        loginSubmit.click();
//        try {
//            sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        WebElement passwordError = driver.findElement(By.id("error-for-password"));
//        Assert.assertTrue(passwordError.isDisplayed(), "Item " + passwordError + "is not displayed");
//    }
//
//    @Test
//    public void negativeLoginTestUserName () {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vryb\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.linkedin.com");
//        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up ");
//        WebElement loginEmail = driver.findElement(By.xpath("//input[@id='login-email']"));
//        loginEmail.sendKeys("semencementbvuibuebvsbvsieubvsievbseseee2@gmail.com");
//        WebElement loginPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
//        loginPassword.sendKeys("Semen1002");
//        WebElement loginSubmit = driver.findElement(By.xpath("//input[@id='login-submit']"));
//        loginSubmit.click();
//        try {
//            sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        WebElement usernameError = driver.findElement(By.id("error-for-username"));
//        Assert.assertTrue(usernameError.isDisplayed(), "Item " + usernameError + "is not displayed");



