package katas.bank;

import katas.bank.transaction.TransactionRepo;
import katas.bank.utils.Calendar;
import katas.bank.utils.Console;
import katas.bank.utils.StatementPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountAcceptanceTest {

    @Mock
    Calendar calendarMock;

    @Mock
    Console console;

    private Account account;

    @BeforeEach
    public void setUp() {
        TransactionRepo transactionRepo = new TransactionRepo();
        StatementPrinter statementPrinter = new StatementPrinter(console);
        account = new Account(calendarMock, transactionRepo, statementPrinter);
    }

    @Test
    public void storeACoupleOfTransactionsAndPrintStatement() {
        // Sarah deposit £500 on her account
        mockDate("27.01.2016");
        account.deposit(500);

        // A couple of month later she withdraw £100
        mockDate("03.11.2016");
        account.withdraw(100);

        // Two years later she deposits £1300
        mockDate("14.08.2018");
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

    private void mockDate(String date) {
        when(calendarMock.todayAsString()).thenReturn(date);
    }
}