package pages;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.DropDown;
import elements.Input;
import objects.Account;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class NewAccountModalWindow extends BasePage {
    public static final SelenideElement saveButton = $x("//*[@name='SaveEdit']");
    public static final SelenideElement saveAndNewButton = $x("//*[@name='SaveAndNew']");
    public static final SelenideElement cancelButton = $x("//*[@name='CancelEdit']");

    public NewAccountModalWindow() {
    }

    public  NewAccountModalWindow openPage(String url) {
        open(url);
        return this;
    }

    public void createAccountWithExit(Account account) {
        new Input("Account Name").writeTextInInput(account.getAccountName());
        new Input("Website").writeTextInInput(account.getWebsite());
        new DropDown("Type").accountSelectOption(account.getType());
        new Input("Description").writeTextInTextarea(account.getDescription());
        new Input("Phone").writeTextInInput(account.getPhone());
        new Button().clickButton(saveButton);
    }
}
