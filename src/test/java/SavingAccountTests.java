import BankAccounts.Account;
import BankAccounts.CheckingAccount;
import BankAccounts.CreditAccount;
import BankAccounts.SavingAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class SavingAccountTests {

    SavingAccount sut;
    static CreditAccount crA = new CreditAccount("testCreditAccount", -50000);
    static CheckingAccount chA = new CheckingAccount("testCheckingAccount", 50000);

    @BeforeEach
    void init() {
        sut = new SavingAccount("testSavingAccount", 50000);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(10000, crA, true), Arguments.of(60000, crA, false), Arguments.of(10000, chA, true),
                Arguments.of(60000, chA, false));
    }

    @ParameterizedTest
    @MethodSource("source")
    void transactionTest(double sum, Account account, boolean expected){

        boolean result = sut.transaction(sum, account);

        assertEquals(expected, result);
    }

    @Test
    void addTest() {
        boolean result = sut.add(10000);

        assertTrue(result);
    }

    @Test
    void getBalanceTest() {
        double expected = 50000;

        double result = sut.getBalance();

        assertEquals(expected, result);
    }

}
