package katas.bank;

import katas.bank.transaction.TransactionRepo;
import katas.bank.utils.Calendar;
import katas.bank.utils.Console;
import katas.bank.utils.StatementPrinter;

public class BankMain {
    public Account account;

    public BankMain() {
        Console console = new Console();

        Calendar calendar = new Calendar();
        TransactionRepo transactionRepo = new TransactionRepo();
        StatementPrinter statementPrinter = new StatementPrinter(console);

        account = new Account(calendar, transactionRepo, statementPrinter);
    }

    public void run() {
        account.deposit(190);
        account.deposit(592);
        account.withdraw(82);
        account.deposit(10);
        account.withdraw(300);

        account.printStatement();
    }
}
