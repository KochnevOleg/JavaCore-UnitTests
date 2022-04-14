import BankAccounts.CheckingAccount;
import BankAccounts.CreditAccount;
import BankAccounts.SavingAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckingAccountTests {

    CheckingAccount sut;
    SavingAccount sa;
    CreditAccount ca;

    @BeforeEach
    public void init() {
        sut = new CheckingAccount("testAccount", 50000);
    }

    @Test
    public void transactionTest() {
        sa = new SavingAccount("testSavingAccount", 10000);
        ca = new CreditAccount("testCreditAccount", -10000);

        boolean trueExpectedSA = sut.transaction(30000, sa);
        boolean falseExpectedSA = sut.transaction(60000, sa);
        boolean falseExpectedCA = sut.transaction(30000, ca);
        boolean trueExpectedCA = sut.transaction(5000, ca);

        assertTrue(trueExpectedSA);
        assertFalse(falseExpectedSA);
        assertFalse(falseExpectedCA);
        assertTrue(trueExpectedCA);
    }

    @Test
    public void addTest() {
        boolean trueExpected = sut.add(20000);

        assertTrue(trueExpected);
    }

    @Test
    public void getBalanceTest() {
         double expected = 50000;

         double result = sut.getBalance();

         assertEquals(expected, result);
    }
}
