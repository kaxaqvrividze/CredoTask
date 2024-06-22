package Tests;
import Steps.LanguagePopUpSteps;
import Steps.LoginPageSteps;
import Utils.LanguageProvider;
import Utils.RandomStringGenerator;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


@Feature("LoginPage Negative Test Cases")
public class LoginPageTests {

    private String language;
    WebDriver driver = new ChromeDriver();
    LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
    RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
    LanguagePopUpSteps languagePopUpSteps = new LanguagePopUpSteps(driver);




    String randString = randomStringGenerator.randomStringGenerator(5,10);
    @BeforeMethod
    public void beforeMethod(Object[] data){
        driver.get("https://mycredo.ge/landing/main/auth");
        driver.manage().window().maximize();
        loginPageSteps.waitMainPage();
        this.language = (String) data[0];


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(dataProvider = "languageProvider", dataProviderClass = LanguageProvider.class,description = "ვცდილობთ სისტემაში შესვლას Username ველის შევსების გარეშე შესვლა ღილაკი ჩათიშულია")
    public void tryingToLoginWithoutUsername(String languageProvider){
        languagePopUpSteps.changeLanguage(languageProvider);
        loginPageSteps.fillPassword(randString)
                .checkDisableLoginButton();


    }

    @Test(dataProvider = "languageProvider", dataProviderClass = LanguageProvider.class,description = "ვცდილობთ სისტემაში შესვლას Password ველის შევსების გარეშე შესვლა ღილაკი ჩათიშული")
    public void tryingToLoginWithoutPassword(String languageProvider){
        languagePopUpSteps.changeLanguage(languageProvider);
        loginPageSteps.fillUsername(randString)
                .checkDisableLoginButton();

    }


    @Test(dataProvider = "languageProvider", dataProviderClass = LanguageProvider.class,description = "ვცდილობთ სისტემაში შესვლას Username Password ველის შევსების გარეშე შესვლა ღილაკი ჩათიშული")
    public void tryingToLoginWithoutUsernameAndPassword(String languageProvider){
        languagePopUpSteps.changeLanguage(languageProvider);
        loginPageSteps.checkDisableLoginButton();

    }
    @Test(dataProvider = "languageProvider", dataProviderClass = LanguageProvider.class,description = "ვცდილობთ სისტემაში შესვლას არასწორი Password-ით")
    public void loginWithWrongPassword(String languageProvider)  {
        languagePopUpSteps.changeLanguage(languageProvider);
        loginPageSteps.fillUsername(randString)
                .fillPassword(randString)
                .clickLoginButton()
                .catchIncorrectDataError(languageProvider);


    }
    @Test(dataProvider = "languageProvider", dataProviderClass = LanguageProvider.class,description = "ვცდილობთ სისტემაში შესვლას არასწორი Username-ით")
    public void loginWithWrongUsername(String languageProvider){
        languagePopUpSteps.changeLanguage(languageProvider);
        loginPageSteps.fillUsername(randString)
                .fillPassword(randString)
                .clickLoginButton()
                .catchIncorrectDataError(languageProvider);
    }

}
