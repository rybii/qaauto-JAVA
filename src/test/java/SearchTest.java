import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class SearchTest extends BaseTest {

    //Example of using 2 before methods
//    @BeforeMethod
//    public void beforeMethod2() {
//
//        System.out.println("2nd before method");
//    }
    @Test
    public void basicSearchTest () {
        String userEmail = "semencement2@gmail.com";
        String userPassword = "Semen1002";
        String searchTerm = "HR";
        Assert.assertTrue(loginPage.isPageLoaded(), "Login Page isn't loaded.");

        HomePage homePage = loginPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");

        SearchResultsPage searchResultsPage = homePage.search(searchTerm);
        Assert.assertTrue(searchResultsPage.isPageLoaded(), "Search results page is not loaded");

        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 10, "Search results count is wrong");

        List<String> searchResults = searchResultsPage.getSearchResultsText();
        for(String searchResult : searchResults){
            Assert.assertTrue(searchResult.contains(searchTerm), "Search term: " + searchTerm + " not found in: \n" + searchResult);
        }
    }

    }



