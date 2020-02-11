package BankKataJava;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountAcceptanceTest {

    @Mock
    Calendar calendarMock;

    @Mock
    Console console;

    private Account account;

    @Before
    public void setUp() {
        account = new Account();
    }

    @Test
    @Ignore
    public void storeACoupleOfTransactionsAndPrintStatement() {
        // Sarah deposit £500 on her account
        when(calendarMock.todayAsString()).thenReturn("27.01.2016");
        account.deposit(500);

        // A couple of month later she withdraw £100
        when(calendarMock.todayAsString()).thenReturn("03.11.2016");
        account.withdraw(100);

        // Two years later she deposits £1300
        when(calendarMock.todayAsString()).thenReturn("14.08.2018");
        account.deposit(1300);

        // When printing the statement
        account.printStatement();

        // She can see the full statement along with a header
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("Date | Amount | Balance");
        inOrder.verify(console).printLine("27.01.2016 | +500 | 500");
        inOrder.verify(console).printLine("03.11.2016 | -100 | 400");
        inOrder.verify(console).printLine("14.08.2018 | +1300 | 1700");
    }
}