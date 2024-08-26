package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    public static final SelenideElement usernameInput = $x("//*[@id='username']");
    public static final SelenideElement passwordInput = $x("//*[@id='password']");
    public static final SelenideElement loginButton = $x("//*[@id='Login']");

    public LoginPage() {
    }

    public LoginPage openPage(String url) {
        open(url);
        return this;
    }

    public LoginPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }
}
