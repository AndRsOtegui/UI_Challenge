package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActorInfoPage extends BasePage {
    public ActorInfoPage(WebDriver driver){super(driver);}

    private final By actingCard = By.xpath("//table[@class=\"card credits\"][1]");


    public boolean searchMovieActorTimeline(String movieTitle){
        logger.info("Searching for movie title in actors timeline");
       return mapLocator(actingCard).getText().contains(movieTitle);
    }
}
