package Steps;

import Page.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginPageSteps extends LoginPage {

    protected WebDriver _driver;
    protected WebDriverWait wait;

    SoftAssert softAssert = new SoftAssert();


    public LoginPageSteps(WebDriver driver) {
        _driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }


    @Step("ელოდება გვერდის ჩატვირთვას")
    public void waitMainPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainPage));
    }


    @Step("ვავსებთ მომხმარებლის ველს")
    public LoginPageSteps fillUsername(String name) {
        _driver.findElement(usernameBy).sendKeys(name);
        return this;
    }

    @Step("ვავსებთ პაროლის ველს")
    public LoginPageSteps fillPassword(String password) {
        _driver.findElement(passwordBy).sendKeys(password);
        return this;
    }

    @Step("ვაკლიკებთ შესვლა ღილაკს")
    public LoginPageSteps clickLoginButton() {
        _driver.findElement(signinBy).click();
        return this;
    }



    @Step("ვამოწმებთ გათიშულ შესვლა ღილაკს")
    public void checkDisableLoginButton() {
        softAssert.assertTrue(Boolean.parseBoolean(_driver.findElement(signinBy).getAttribute("disabled")));

    }

    @Step("ვამოწმებთ ერორ შეტყობინებას არასწორ მონაცემებზე")
    public void catchIncorrectDataError(String language) {
        switch (language) {
            case "ქართული":
                softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectDataGe)).isDisplayed());

                break;
            case "მეგრული":
                softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectDataMegruli)).isDisplayed());
                break;
            case "სვანური":

                softAssert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectDataSvanuri)).isDisplayed());
                break;
        }
    }







}
