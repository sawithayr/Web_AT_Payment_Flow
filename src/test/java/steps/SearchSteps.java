package steps;

import io.cucumber.java.en.And;
import pages.KostListingPO;
import pages.SearchPO;
import tests.TestBase;

public class SearchSteps extends TestBase {

    private SearchPO search = new SearchPO(driver);
    private KostListingPO kostListing = new KostListingPO(driver);

    @And("user fills search box with keyword {string} and selects matching result")
    public void userFillsSearchBoxWithKeywordAndSelectsMatchingResult(String word) throws InterruptedException {
        search.inputKeyword(word);
        search.clickTheFirstResultArea();
        kostListing.closeFTUEKosListingPopUp();


    }
}
