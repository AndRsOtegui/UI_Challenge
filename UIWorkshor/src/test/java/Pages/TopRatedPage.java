package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Random;

public class TopRatedPage extends BasePage{
    public TopRatedPage(WebDriver driver){super(driver);}


    Random random = new Random();
    int randomInt = random.nextInt(10-1+1)+1;

    int checkerOrderFirst4=0;

    private final By actionFilterBTn = By.xpath("//a[contains(text(),'Action')]/..");
    private final  By searchByFilterBtn = By.xpath("//div[@class=\"apply full background_color light_blue enabled fixed\"]//a");
    private final By anyMovieResultBtn = By.xpath("//div[@class=\"card style_1\"]["+randomInt+"]");

    private final By sortScrollDownBtn = By.xpath("//h2[contains(text(),\"Sort\")]/..");

    private final By downArrowSortByBtn = By.xpath("//div[@class=\"filter_panel card\"][1]//span[@class=\"k-icon k-i-arrow-60-down\"]");

    private final By scrollDownAscendingDateSelect = By.xpath("//li[contains(text(),\"Release Date Ascending\")]");

    public final By closeCoockiesBtn = By.xpath("//div[@id]/button[@aria-label=\"Close\"]");

    private final By wrapperCardsMovies = By.xpath("//div[@id=\"page_1\"]");
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));



    public MovieInfoPage filterActionGenre(){
        mapLocator(closeCoockiesBtn).click();
        mapLocator(actionFilterBTn).click();
        mapLocator(searchByFilterBtn).click();
        logger.info("Activate action filter search");

        wait.until(ExpectedConditions.jsReturnsValue("return (typeof jQuery != 'undefined') && jQuery.active == 0;"));
        logger.info("Wait until all query's are run");
        mapLocator(anyMovieResultBtn).click();
        logger.info("Choose random movie");
        return new MovieInfoPage(this.driver);


    }

    public boolean orderAscendingReleaseDate(){
        boolean ascendingOrder = false;
        mapLocator(closeCoockiesBtn).click();
        mapLocator(sortScrollDownBtn).click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        mapLocator(downArrowSortByBtn).click();
        mapLocator(scrollDownAscendingDateSelect).click();
        mapLocator(searchByFilterBtn).click();
        logger.info("Sorting by ascending release date");


        wait.until(ExpectedConditions.jsReturnsValue("return (typeof jQuery != 'undefined') && jQuery.active == 0;"));
        logger.info("Wait until all query's are run");

        String date1 = mapLocator(By.xpath("//div[@id=\"page_1\"]/div["+1+"]//p")).getText();
        String year = date1.substring(date1.length()-4);
        int dateYear1 =Integer.parseInt(year);

        String date2 = mapLocator(By.xpath("//div[@id=\"page_1\"]/div["+2+"]//p")).getText();
        String year2 = date2.substring(date2.length()-4);
        int dateYear2 =Integer.parseInt(year2);

        String date3 = mapLocator(By.xpath("//div[@id=\"page_1\"]/div["+3+"]//p")).getText();
        String year3 = date3.substring(date3.length()-4);
        int dateYear3 =Integer.parseInt(year3);

        String date4 = mapLocator(By.xpath("//div[@id=\"page_1\"]/div["+4+"]//p")).getText();
        String year4 = date4.substring(date4.length()-4);
        int dateYear4 =Integer.parseInt(year4);

        logger.info("Verifying order: "+dateYear1+" <? "+dateYear2+" <? "+dateYear3+" <? "+dateYear4);

        if(dateYear1<dateYear2 && dateYear2<dateYear3 && dateYear3<dateYear4){
            logger.info("Is in ascending order");
           ascendingOrder = true;
        }
        else{
            logger.severe("Not in ascending order");
        }



       return ascendingOrder;


    }


}
