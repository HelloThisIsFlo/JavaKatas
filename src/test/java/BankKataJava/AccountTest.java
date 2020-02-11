package BankKataJava;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    Calendar calendarMock;

    @Mock
    TransactionRepo transactionRepoMock;

    private Account account;

    @Before
    public void setUp() {
        account = new Account(calendarMock, transactionRepoMock);
    }

    @Test
    public void itShouldAddDateAndStoreADeposit() {
        int amount = 1234;
        String date = "fakeDate";

        mockDate(date);
        account.deposit(amount);

        verify(transactionRepoMock).save(new Transaction(amount, date));
    }

    private void mockDate(String date) {
        when(calendarMock.todayAsString()).thenReturn(date);
    }
}