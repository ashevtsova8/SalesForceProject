package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Input {
    String label;

    private static final String INPUT_XPATH =
            "//*[contains(text(),'%s')]/ancestor::div[contains(@part,'input-text')]//input";
    private static final String TEXTAREA_XPATH =
      "//*[contains(text(),'%s')]/ancestor::*[contains(@slot,'inputField')]//textarea";

    public Input(String label) {
        this.label = label;
    }

    public void writeTextInInput(String text) {
        $(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }

    public void writeTextInTextarea(String text) {
        $(By.xpath(String.format(TEXTAREA_XPATH, label))).sendKeys(text);
    }
}
