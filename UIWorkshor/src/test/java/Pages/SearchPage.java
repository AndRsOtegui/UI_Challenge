package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver){super(driver);}

    private final By firstResult = By.xpath("//div[@class=\"search_results movie \"]/div/div[1]");

    public String getFirstResult(){
        logger.info("Select first movie");
        return mapLocator(firstResult).getText();
    }




}
