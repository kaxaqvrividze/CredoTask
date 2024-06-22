package Steps;

import Page.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguagePopUpSteps extends LoginPage {

    protected WebDriver _driver;
    public LanguagePopUpSteps(WebDriver driver) {
        _driver = driver;


    }

    @Step("ენის ცვლილება")
    public void changeLanguage(String language) {
        _driver.findElement(languageBtn).click();
        _driver.findElement(By.xpath("//div[@class='sub-language']//p[text()=\"" + language + "\"]")).click();
    }

}
