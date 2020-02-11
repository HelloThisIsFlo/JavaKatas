package BankKataJava.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepo {
    private List<Transaction> transactions;

    public TransactionRepo() {
        this.transactions = new ArrayList<>();
    }

    public void save(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public List<Transaction> allTransactions() {
        return List.copyOf(this.transactions);
    }
}
