import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class LoginPage {

    //названия переменных
    WebDriver driver;

    WebElement userEmailField;
    WebElement userPasswordField;
    WebElement signInButton;
    WebElement userEmailField1;
    WebElement userEmailFieldPlaceholder;


    //
    public LoginPage (WebDriver driver){  //экземпляр класса LoginPage
        this.driver = driver; //
        initElements(); //метод класса
    }

    //присваиваем переменным значения
    public void initElements () {
        userEmailField  = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField  = driver.findElement(By.xpath("//input[@id='login-password']"));
        signInButton  = driver.findElement(By.xpath("//input[@id='login-submit']"));
        userEmailField1 = driver.findElement(By.xpath("//input[@id='login-email']"));
        userEmailFieldPlaceholder = driver.findElement(By.xpath("//input[@placeholder='Email']"));
    }

    public void login(String userEmail, String userPassword) { // to change parameters
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();

        try {
            sleep(3000);
        } catch (InterruptedException e) { //ждать 3сек
            e.printStackTrace();
        }

    }

}
