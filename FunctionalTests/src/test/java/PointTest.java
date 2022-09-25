import PointPackage.ActionManager;
import PointPackage.Pages.FootballPage;
import PointPackage.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PointTest {
    public static MainPage mainPage;
    public static FootballPage footballPage;
    public static ActionManager actionManager;
    public static WebDriver driver;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        footballPage = new FootballPage(driver);
        actionManager = new ActionManager();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfigProperties.getProperty("loginpage"));
    }

    @Test
    public void sumPointTest() throws InterruptedException {
        mainPage.clickFootball();
        footballPage.clickFootball();
        Thread.sleep(1000);
        footballPage.clickArsenal();
        var matchResults= actionManager.parsingMatchResult(footballPage.getMatchResults());
        var sumPoint = actionManager.convertToInt(footballPage.getNumberPoint());
        Point point = new Point(matchResults[0], matchResults[1], matchResults[2]);
        Assert.assertEquals(sumPoint, point.sumPoint());
    }

    @AfterTest
    public static void complite() {
        driver.quit();
    }

}
