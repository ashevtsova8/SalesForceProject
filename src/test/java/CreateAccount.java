import objects.Account;
import org.testng.annotations.BeforeMethod;

public class CreateAccount extends BaseTest {
    Account account1 = new Account();

    @BeforeMethod
    public void createAccount() {
        account1
                .setAccountName("account" + numberGenerator.generateRandomInt(50))
                .setWebsite("account1.com")
                .setType("Analyst")
                .setPhone("111")
                .setDescription("this is first account");
    }
}
