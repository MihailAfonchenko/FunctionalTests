import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        driver = webDriver;
    }

    @FindBy(xpath = "//a[@id='enter_link']")
    private WebElement logInBtn;

    @FindBy(xpath = "//a[@href='/ums_profile']")
    private WebElement logOutField;

    @FindBy(xpath = "//a[@href='/ums_profile']")
    private WebElement loginField;

    @FindBy(xpath = "//a[@href= '/Vidy_sporta/Futbol'][1]")
    private WebElement footballField;

    public void clickLogIn() {
        logInBtn.click();
    }

    public void clickLogOut() {
        logOutField.click();
    }

    public void clickProfile() {
        loginField.click();
    }

    public void clickFootball() {
        footballField.click();
    }
}
