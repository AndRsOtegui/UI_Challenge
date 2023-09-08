package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.logging.Logger;
import java.io.IOException;
import java.util.logging.FileHandler;


public class BasePage {
    protected static final Logger logger = Logger.getLogger(BasePage.class.getName());


    protected WebDriver driver;


     public final By navbarMoviesBtn = By.xpath("//a[@href=\"/movie\"][contains(text(),'Movies')]");
     public final By scrollDownTopRatedMovies = By.xpath("//a[@href=\"/movie/top-rated\"]");

    public final By closeCoockiesBtn = By.xpath("//div[@id]/button[@aria-label=\"Close\"]");
    public BasePage(WebDriver driver){
        this.driver = driver;
        configureLogger();
    }
    private void configureLogger() {
        try {
            FileHandler fileHandler = new FileHandler("TestUILog.log");
            fileHandler.setFormatter(new LogTextFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public WebElement mapLocator(By element){
        return driver.findElement(element);
    }
}
