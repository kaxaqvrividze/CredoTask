package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {

    protected  final By mainPage = By.id("authloading");

    protected final By languageBtn = By.id("languageSwitcherBtn");
    protected final By usernameBy = By.id("userName");
    protected final By passwordBy = By.id("newPass");


    protected final By incorrectDataGe= By.xpath("//p[text()='მონაცემები არასწორია']");
    protected final By incorrectDataSvanuri= By.xpath("//p[text()='მონაცემოლ სწორ დემეგ ლი']");
    protected final By incorrectDataMegruli= By.xpath("//p[text()='მუნაჩემეფი ვა რე თინუ']");


    protected final By signinBy = By.id("submitAuth");

}
