import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class LoginPage {

    //названия переменных (поля/свойства класса)
    private WebDriver driver;

    private WebElement userEmailField;
    private WebElement userPasswordField;
    private WebElement signInButton;

    //конструктор объекта класса, метод который выаолняется сразу после создания переменных
    public LoginPage (WebDriver driver){  //экземпляр класса LoginPage
        this.driver = driver; //открытие браузера
        initElements(); //метод класса
    }

    //присваиваем переменным значения
    private void initElements () {
        userEmailField  = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField  = driver.findElement(By.xpath("//input[@id='login-password']"));
        signInButton  = driver.findElement(By.xpath("//input[@id='login-submit']"));
    }

    public HomePage login(String userEmail, String userPassword) { // to change parameters
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) { //ждать 3сек
            e.printStackTrace();
        }
        return new HomePage(driver);
    }

    public LoginPage loginToLogin(String userEmail, String userPassword) { // to change parameters
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) { //ждать 3сек
            e.printStackTrace();
        }
        return new LoginPage(driver);
    }

    public LoginSubmitPage loginSubmitPage(String userEmail, String userPassword) { // to change parameters
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) { //ждать 3сек
            e.printStackTrace();
        }
        return new LoginSubmitPage(driver);
    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().contains("LinkedIn: Log In or Sign Up ")
                && signInButton.isDisplayed();

    }
}
