package gui.pages;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Home {

    //Variables
    private WebDriver driver;
    private static final String URL = System.getProperty("googleURL");


    //Locators
    public static By google_Logo()
    {
        return  By.xpath("//img[@alt='Google']");
    }

    private static By search_TextBox()
    {
        return  By.name("q");
    }


    //Constructor
    public  Home(WebDriver driver)
    {
        this.driver = driver;
    }

    //Keywords

    /**
     * Navigates to google url
     * @return  self-reference
     */
    public Home navigate()
    {
        BrowserActions.navigateToURL(driver, URL);
        return this;
    }

    /**
     * Searches for a given string and presses enter
     * @param query the query that you want to search for
     * @return self-reference
     */
    public Results searchForQuery(String query)
    {
//        (new ElementActions(driver)).type(search_TextBox(), query)
//                .keyPress(search_TextBox(), Keys.ENTER);

        ElementActions.type(driver, search_TextBox(), query);
        ElementActions.keyPress(driver, search_TextBox(), Keys.ENTER);
        return new Results(driver);
    }
}
