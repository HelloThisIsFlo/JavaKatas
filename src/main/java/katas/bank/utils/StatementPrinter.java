package katas.bank.utils;

import katas.bank.transaction.Transaction;

import java.util.List;

public class StatementPrinter {

    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactions) {
        printHeader();
        printTransactions(transactions);
    }

    private void printHeader() {
        console.printLine("Date | Amount | Balance");
    }

    private void printTransactions(List<Transaction> transactions) {
        int balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.amount;
            console.printLine(formatTransaction(transaction, balance));
        }
    }

    private String formatTransaction(Transaction transaction, int balance) {
        String formattedAmount = transaction.amount > 0 ?
                "+" + transaction.amount :
                "" + transaction.amount;
        return transaction.date + " | " + formattedAmount + " | " + balance;
    }

}
