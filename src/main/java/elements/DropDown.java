package elements;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DropDown {
    String label;

  private static final String ACCOUNT_DROPDOWN_XPATH =
      "//*[contains(text(),'%s')]/ancestor::*[contains(@slot,'inputField')]//button";
  private static final String ACCOUNT_DROPDOWN_OPTION_XPATH =
      "//div[contains(@class,'slds-combobox_container')" +
              "]//lightning-base-combobox-item//*[contains(@title,'%s')]";

    public DropDown(String label) {
        this.label = label;
    }

    public void accountSelectOption(String option) {
        $(By.xpath(String.format(ACCOUNT_DROPDOWN_XPATH, label))).click();
        $(By.xpath(String.format(ACCOUNT_DROPDOWN_OPTION_XPATH, option))).scrollTo().click();
    }
}
