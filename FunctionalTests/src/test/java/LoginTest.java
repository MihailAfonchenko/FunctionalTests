import LoginPackage.Pages.LoginPage;
import LoginPackage.Pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeTest
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfigProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() throws InterruptedException {
        mainPage.clickLogIn();
        loginPage.clickEnterTransition();
        loginPage.inputNumber(ConfigProperties.getProperty("number"));
        loginPage.clickFurther();
        loginPage.inputPassword(ConfigProperties.getProperty("password"));
        loginPage.clickEnter();
        mainPage.clickProfile();
        String userEmail = profilePage.getUserEmail();
        Assert.assertEquals(ConfigProperties.getProperty("email"), userEmail);
    }

    @AfterTest
    public static void complite() {
        profilePage.returnToMain();
        mainPage.clickLogOut();
        driver.quit();
    }
}
