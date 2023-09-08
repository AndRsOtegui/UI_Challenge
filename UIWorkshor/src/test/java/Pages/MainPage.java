package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class MainPage extends BasePage {

    private final By loginBtn = org.openqa.selenium.By.xpath("//header//a[@href=\"/login\"]");

    private final By searchBar = By.xpath("//input[@id=\"inner_search_v4\"]");
    private final By searchButton = By.xpath("//input[@value=\"Search\"]");

    private final By anyMovieBtn = By.xpath("//div[@id=\"trending_scroller\"]//div[@class=\"card style_1\"][1]");
    JavascriptExecutor js = (JavascriptExecutor) driver;


    public MainPage(WebDriver driver){super(driver);}

    public LoginPage goLogin(){
        logger.info("---------------------START TEST--------------------------------------");
        mapLocator(loginBtn).click();
        logger.info("Login button clicked");
        return new LoginPage(this.driver);
    }

    public SearchPage searchMovie(String movieToSearch){
        logger.info("---------------------START TEST--------------------------------------");
        mapLocator(searchBar).sendKeys(movieToSearch);
        logger.info("Enter movie search");
        mapLocator(searchButton).click();
        logger.info("Search movie");
        return new SearchPage(this.driver);
    }

    public TopRatedPage goTopRatedMovies(){
        logger.info("---------------------START TEST--------------------------------------");
        mapLocator(navbarMoviesBtn).click();
        logger.info("Movies button in navbar clicked");
        mapLocator(scrollDownTopRatedMovies).click();
        logger.info("Clicked on Top Rated movies");
        return new TopRatedPage(this.driver);
    }

    public MovieInfoPage goToMovie(){
        logger.info("---------------------START TEST--------------------------------------");
        js.executeScript("window.scrollBy(0, 500);");
        mapLocator(anyMovieBtn).click();
        logger.info("Choose random movie");
        return new MovieInfoPage(this.driver);
    }

}
