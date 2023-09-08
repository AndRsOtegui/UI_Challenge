package UItest;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks {
    protected WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.themoviedb.org/");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
      if (driver != null) {
            driver.quit();
        }
    }
}
