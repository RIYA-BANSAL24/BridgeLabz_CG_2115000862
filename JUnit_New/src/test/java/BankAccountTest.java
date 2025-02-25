import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(100.0);
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(50.0);
        assertEquals(150.0, bankAccount.getBalance(), "Balance should be updated after deposit");
    }

    @Test
    void testWithdraw() {
        bankAccount.withdraw(40.0);
        assertEquals(60.0, bankAccount.getBalance(), "Balance should be updated after withdrawal");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(200.0));
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testNegativeDeposit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-20.0));
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    void testNegativeWithdraw() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-10.0));
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }
}