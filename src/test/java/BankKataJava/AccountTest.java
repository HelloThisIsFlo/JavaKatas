package BankKataJava;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    Calendar calendarMock;

    @Mock
    TransactionRepo transactionRepoMock;

    @Mock
    StatementPrinter statementPrinterMock;

    private Account account;

    @Before
    public void setUp() {
        account = new Account(calendarMock, transactionRepoMock, statementPrinterMock);
    }

    @Test
    public void itShouldAddDateAndStoreADeposit() {
        int amount = 1234;
        String date = "fakeDate";

        mockDate(date);
        account.deposit(amount);

        verify(transactionRepoMock).save(new Transaction(amount, date));
    }

    @Test
    public void itShouldAddDateAndStoreAWithdrawal() {
        int amount = 3456;
        String date = "anotherFakeDate";

        mockDate(date);
        account.withdraw(amount);

        int expectedTransactionAmount = -amount;
        verify(transactionRepoMock).save(new Transaction(expectedTransactionAmount, date));
    }

    @Test
    public void itShouldPrintAllTransactions() {
        List<Transaction> mockTransactions = List.of(
                new Transaction(1234, "date1"),
                new Transaction(3456, "date2"),
                new Transaction(9999, "date3")
        );
        when(transactionRepoMock.allTransactions()).thenReturn(mockTransactions);

        account.printStatement();

        verify(statementPrinterMock).print(mockTransactions);
    }

    private void mockDate(String date) {
        when(calendarMock.todayAsString()).thenReturn(date);
    }
}