package katas.bank.utils;

import katas.bank.transaction.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StatementPrinterTest {

    @Mock
    Console consoleMock;

    private StatementPrinter statementPrinter;

    @BeforeEach
    public void setUp() {
        statementPrinter = new StatementPrinter(consoleMock);
    }

    @Test
    public void itShouldPrintHeaderOnly_whenNoTransactions() {
        statementPrinter.print(List.of());
        verify(consoleMock).printLine("Date | Amount | Balance");
    }

    @Test
    public void itShouldPrintAllTransactionsWithBalance() {
        List<Transaction> mockTransactions = List.of(
                new Transaction(400, "date1"),
                new Transaction(-100, "date2"),
                new Transaction(1000, "date3")
        );

        statementPrinter.print(mockTransactions);

        InOrder inOrder = inOrder(consoleMock);
        inOrder.verify(consoleMock).printLine("Date | Amount | Balance");
        inOrder.verify(consoleMock).printLine("date1 | +400 | 400");
        inOrder.verify(consoleMock).printLine("date2 | -100 | 300");
        inOrder.verify(consoleMock).printLine("date3 | +1000 | 1300");
    }

}