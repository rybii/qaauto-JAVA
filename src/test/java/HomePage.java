import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class HomePage {
    private WebDriver driver;
    private WebElement profileMenuItem;
    private WebElement userNameText;
    private WebElement searchField;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {

        profileMenuItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
        searchField = driver.findElement(By.xpath("//form[@id='extended-nav-search']//input"));
    }

    public boolean isProfileMenuItemDisplayed (){
        return profileMenuItem.isDisplayed();

    }
    public void clickOnProfileMenu (){
        profileMenuItem.click();

    }

    public String getUserNameTextDisplayed (){
        userNameText = driver.findElement(By.xpath("//ul[@id='nav-settings__dropdown-options']//h3"));
        return userNameText.getText();
    }

    public boolean isPageLoaded (){
        return profileMenuItem.isDisplayed();

    }

    public SearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchResultsPage(driver);


    }
}
