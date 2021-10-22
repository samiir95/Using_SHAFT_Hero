package test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import gui.pages.Home;
import gui.pages.Results;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {

    private WebDriver driver;
    private JSONFileManager testData = new JSONFileManager("src/test/resources/TestDataFiles/googleSearch.json");

    @Description("Given that the browser is opened, when I navigate to chrome url, then the google logo is displayed")
    @Test(description = "Check that google logo is displayed")
    public void checkThatGoogleLogoIsDisplayed() {
        new Home(driver).navigate();
        Validations.assertThat()
                .element(driver, Home.google_Logo())
                .matchesReferenceImage()
                .withCustomReportMessage("Assert that google logo is displayed!")
                .perform();
    }

    @Description("Given that the browser is opened, when I navigate to google url and search for SHAFT_ENGINE, then the result stats will be empty")
    @Test(description = "Check that result stats is not empty when I search for SHAFT_ENGINE")
    public void checkThatResultStatsIsNotEmpty() {
        new Home(driver).navigate().searchForQuery(testData.getTestData("searchQuery"));
        Validations.assertThat()
                .element(driver, Results.resultStats_Label())
                .text()
                .doesNotEqual("")
                .withCustomReportMessage("Assert that result stats is not empty")
                .perform();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
        BrowserActions.closeCurrentWindow(driver);

    }
}
