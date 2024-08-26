import com.codeborne.selenide.Configuration;
import constants.IConstants;
import generators.NumberGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest implements ITestConstants, IConstants {
    AccountPage accountPage;
    AccountListPage accountListPage;
    HomePage homePage;
    LoginPage loginPage;
    NewAccountModalWindow newAccountModalWindow;
    NumberGenerator numberGenerator;

    public void initPages() {
        accountPage = new AccountPage();
        accountListPage = new AccountListPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        newAccountModalWindow = new NewAccountModalWindow();
    }

    public void initUtils() {
        numberGenerator = new NumberGenerator();
    }

    @BeforeMethod
    public void initTest() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
//        Configuration.browserSize = "2560x1600";
        getWebDriver().manage().window().maximize();

        Configuration.timeout = 15000;
//        Configuration.holdBrowserOpen = true;
        Configuration.headless = false;

        initPages();
        initUtils();
    }

    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}
