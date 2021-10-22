package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {

    //Variables
    private WebDriver driver;


    //Locators
    public static By resultStats_Label()
    {
        return By.id("result-stats");
    }


    //Constructor
    public Results(WebDriver driver)
    {
        this.driver = driver;
    }

    //Keywords

}
