package katas.bank.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TransactionRepoTest {
    private TransactionRepo transactionRepo;

    @BeforeEach
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