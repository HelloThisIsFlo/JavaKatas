package BankKataJava;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransactionRepoTest {
    private TransactionRepo transactionRepo;

    @Before
    public void setUp() {
        transactionRepo = new TransactionRepo();
    }

    @Test
    public void itShouldSaveTransactions() {
        Transaction transaction1 = new Transaction(1111, "date1");
        Transaction transaction2 = new Transaction(2222, "date2");
        Transaction transaction3 = new Transaction(-3333, "date3");

        transactionRepo.save(transaction1);
        transactionRepo.save(transaction2);
        transactionRepo.save(transaction3);

        assertEquals(List.of(transaction1, transaction2, transaction3), transactionRepo.allTransactions());
    }
}