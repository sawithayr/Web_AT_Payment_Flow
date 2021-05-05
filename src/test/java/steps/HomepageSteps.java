package steps;

import io.cucumber.java.en.And;
import pages.HomePagePO;
import tests.TestBase;

public class HomepageSteps extends TestBase {

    private HomePagePO homepage = new HomePagePO(driver);

    @And("user clicks on Enter Button navbar")
    public void userClicksOnEnterButtonNavbar() throws InterruptedException {
        homepage.clickLoginButtonNavbar();
    }

    @And("user clicks search bar")
    public void userClicksSearchBar() throws InterruptedException {
        homepage.clickSearchBar();
    }

}
