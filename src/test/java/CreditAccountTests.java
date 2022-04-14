import BankAccounts.Account;
import BankAccounts.CreditAccount;
import BankAccounts.SavingAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class CreditAccountTests {

    CreditAccount sut;

    @BeforeEach
    void init() {
        sut = new CreditAccount("testAccount", -50000);
    }

    @ParameterizedTest
    @MethodSource("source")
    void transactionTest(double sum, boolean expected) {
        Account sa = new SavingAccount("testSavingAccount", 10000);

        boolean result = sut.transaction(sum, sa);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    void addTest(double sum, boolean expected) {

        boolean result = sut.add(sum);

        assertEquals(expected, result);
    }

    @Test
    void getBalanceTest() {
        double expected = -50000;
        double result = sut.getBalance();
        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(10000, true), Arguments.of(60000, false));
    }
}
