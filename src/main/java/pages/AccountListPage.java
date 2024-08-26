package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AccountListPage extends BasePage {
    public static final String ACCOUNT_NAME_FIELD_XPATH = "//*[contains(@title,'%s')]";
    public static final String PHONE_BY_ACCOUNT_NAME_FIELD_XPATH = "//*[contains(@title,'%s')" +
            "]/ancestor::tbody//span[contains(@class,'forceOutputPhone')]";
    public static final String ACCOUNT_OWNER_BY_ACCOUNT_NAME_FIELD_XPATH =
            "//*[contains(@title,'%s')]/ancestor::tr//span[contains(@class,'uiOutputText')]";

    public AccountListPage() {

    }

    public AccountListPage openPage(String url) {
        open(url);
        return this;
    }

    public String getExistAccountName(String accountName) {
        return $(By.xpath(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName))).getText();
    }

    public String getExistPhoneByAccountName(String accountName) {
        return $(By.xpath(String.format(PHONE_BY_ACCOUNT_NAME_FIELD_XPATH, accountName))).getText();
    }

    public String getExistAccountOwnerByAccountName(String accountName) {
        return $(By.xpath(String.format(ACCOUNT_OWNER_BY_ACCOUNT_NAME_FIELD_XPATH, accountName))).getText();
    }

    public AccountPage clickOnAccountName(String accountName) {
        $(By.xpath(String.format(ACCOUNT_NAME_FIELD_XPATH, accountName))).click();
        return new AccountPage();
    }
}
