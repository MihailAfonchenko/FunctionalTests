package LoginPackage.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        driver = webDriver;
    }

    @FindBy(xpath = "//button[contains(text(), 'Войти с ГИД')]")
    private WebElement enterTransitionBtn;

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private WebElement enterBtn;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement furtherField;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement numberField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    public void clickEnterTransition() {
        enterTransitionBtn.click();
    }

    public void inputNumber(String password) {
        numberField.sendKeys(password);
    }

    public void clickFurther() {
        furtherField.click();
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickEnter() {
        enterBtn.click();
    }
}
