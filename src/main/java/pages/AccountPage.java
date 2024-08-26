package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage {
    public static final String DATA_BY_LABEL_XPATH = "//*[@field-label='%s']//*[@data-output" +
            "-element-id='output-field']";

    public AccountPage() {
        super();
    }

    public String getFieldValueByName(String name) {
        return $(By.xpath(String.format(DATA_BY_LABEL_XPATH, name))).getText();
    }
}
