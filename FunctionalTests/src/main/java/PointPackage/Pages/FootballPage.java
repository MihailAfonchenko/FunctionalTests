package PointPackage.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FootballPage {
    public WebDriver driver;
    public FootballPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        driver = webDriver;
    }

    @FindBy(xpath = "//a[@href= '/Vidy_sporta/Futbol'][1]")
    private WebElement footballField;

    @FindBy(xpath = "//a[@title = 'Арсенал']")
    private WebElement arsenalField;

    @FindBy(xpath = "//tr[@data-team = '1123155060']/td[4]/a/span[1]")
    private WebElement matchResults;

    @FindBy(xpath = "//tr[@data-team = '1123155060']/td[6]/a/span[1]")
    private WebElement numberPoint;

    public void clickFootball() {
        footballField.click();
    }

    public void clickArsenal() {
        arsenalField.click();
    }

    public String getMatchResults() {
        return matchResults.getText();
    }

    //суммарное кол-во очков
    public String getNumberPoint() {
        return numberPoint.getText();
    }

}
