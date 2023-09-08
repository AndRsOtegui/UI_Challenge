package Pages;

import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver driver){super(driver);}
    public boolean getLoggedIn(){
        logger.info("Enter profile page");
        return true;
    }

}
