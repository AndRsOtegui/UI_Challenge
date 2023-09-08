package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Random;

public class MovieInfoPage extends BasePage {
    public MovieInfoPage(WebDriver driver){super(driver);}
    private final By anyMovieResultGenre = By.xpath("//span[@class=\"genres\"]");

    private final By movieTitle = By.xpath("//h2[@class]/a");
    Random random = new Random();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public String getMovieGenre(){
        return mapLocator(anyMovieResultGenre).getText();
    }

   public String getMovieTittle(){
       js.executeScript("window.scrollBy(0, 500);");
       logger.info("Getting movie title");
       return mapLocator(movieTitle).getText();
    }
    public ActorInfoPage selectActor(){

        java.util.List<WebElement> elements = driver.findElements(By.xpath("//ol[@class=\"people scroller\"]"));
        int elementCount = elements.size();
        logger.info("Getting number of bill actor cast");
        int randomInt = random.nextInt(elementCount-1+1)+1;
        driver.findElement(By.xpath("//ol[@class=\"people scroller\"]["+randomInt+"]")).click();
        logger.info("Select one of the actors");
        return new ActorInfoPage(this.driver);

    }
}
