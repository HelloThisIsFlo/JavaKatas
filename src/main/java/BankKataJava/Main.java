package BankKataJava;

import BankKataJava.transaction.TransactionRepo;
import BankKataJava.utils.Calendar;
import BankKataJava.utils.Console;
import BankKataJava.utils.StatementPrinter;

public class Main {
    public static void main(String[] args) {

        Console console = new Console();

        Calendar calendar = new Calendar();
        TransactionRepo transactionRepo = new TransactionRepo();
        StatementPrinter statementPrinter = new StatementPrinter(console);

        Account account = new Account(calendar, transactionRepo, statementPrinter);

        account.deposit(190);
        account.deposit(592);
        account.withdraw(82);
        account.deposit(10);
        account.withdraw(300);

        account.printStatement();
    }
}
