import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {
    @Test
    public void checkAccountExistInAccountsListTest() {
        Account account1 = new Account();
        account1
                .setAccountName("account" + numberGenerator.generateRandomInt(50))
                .setWebsite("account1.com")
                .setType("Analyst")
                .setPhone("111")
                .setDescription("this is first account");

        loginPage
                .openPage(LOGIN_URL)
                .login(USERNAME, PASSWORD);
        newAccountModalWindow
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createAccountWithExit(account1);

        accountListPage
                .openPage(ACCOUNT_LIST_URL);

        Assert.assertEquals(
                accountListPage.getExistAccountName(account1.getAccountName()),
                account1.getAccountName());
        Assert.assertEquals(
                accountListPage.getExistPhoneByAccountName(account1.getAccountName()),
                account1.getPhone());
        Assert.assertEquals(
                accountListPage.getExistAccountOwnerByAccountName(account1.getAccountName()),
                "AShev");
  }

    @Test
    public void checkAccountDataOnAccountPageTest() {
        Account account2 = new Account();
        account2
                .setAccountName("account" + numberGenerator.generateRandomInt(50))
                .setWebsite("account2.com")
                .setType("Customer")
                .setPhone("222")
                .setDescription("this is second account");

        loginPage
                .openPage(LOGIN_URL)
                .login(USERNAME, PASSWORD);
        newAccountModalWindow
                .openPage(NEW_ACCOUNT_MODAL_URL)
                .createAccountWithExit(account2);

        Assert.assertEquals(
                accountPage.getFieldValueByName("Account Name"),
                account2.getAccountName());
        Assert.assertEquals(
                accountPage.getFieldValueByName("Website"),
                account2.getWebsite());
        Assert.assertEquals(
                accountPage.getFieldValueByName("Type"),
                account2.getType());
        Assert.assertEquals(
                accountPage.getFieldValueByName("Description"),
                account2.getDescription());
        Assert.assertEquals(
                accountPage.getFieldValueByName("Phone"),
                account2.getPhone());
    }
}
