package LoginPackage.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        driver = webDriver;
    }

    @FindBy(xpath = "//input[@name = 'user-email']")
    private WebElement email;

    @FindBy(xpath = "//a[text()='На главную']")
    private WebElement returnToMainPageBtn;

    public String getUserEmail() {
        return email.getAttribute("value");
    }

    public void returnToMain() {
        returnToMainPageBtn.click();
    }
}
