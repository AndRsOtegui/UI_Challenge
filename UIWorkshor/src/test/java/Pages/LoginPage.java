package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.Objects;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){super(driver);}

    private final By inputUserName = By.xpath("//input[@id=\"username\"]");
    private final By inputPassword = By.xpath("//input[@id=\"password\"]");
    private final By loginBtnLp = org.openqa.selenium.By.xpath("//input[@id=\"login_button\"]");
    private final By errorMessageLogin = By.xpath("//h2[@class]");
    private final By title = By.xpath("//h2[@class]/child::span");

    private final By errorMessageText1 = By.xpath("//div[@class=\"content\"]/ul/li[contains(text(), 'We')]");
    private final By errorMessageText2 = By.xpath("//div[@class=\"content\"]/ul/li[contains(text(), 'You')]");




    public ProfilePage enterCredentials(String userName,String passWord){
        logger.info("Enter login page");
        mapLocator(inputUserName).sendKeys(userName);
        logger.info("Input username");
        mapLocator(inputPassword).sendKeys(passWord);
        logger.info("Input password");
        mapLocator(loginBtnLp).click();
        logger.info("Click on Login button");
        return new ProfilePage(this.driver);
    }

    public void wrongCredentials(){
        mapLocator(inputUserName).sendKeys("Andres");
        logger.info("Enter wrong username");
        mapLocator(inputPassword).sendKeys("1234");
        logger.info("Enter wrong password");
        mapLocator(loginBtnLp).click();
        logger.info("Click on Login button");
    }

    public String getColorBlock(){
        return mapLocator (errorMessageLogin).getCssValue ("background-color");
    }

    public String getTextTitle(){
        logger.info("Saving selected movie title");
        return mapLocator(title).getText();

    }

    public boolean getErrorMessages(){
        logger.info("Verifying error message structure");
        return !mapLocator(errorMessageText1).getText().isEmpty() && !mapLocator(errorMessageText2).getText().isEmpty();
    }

}
