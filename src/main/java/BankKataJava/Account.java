package BankKataJava;

public class Account {
    private Calendar calendar;
    private TransactionRepo transactionRepo;
    private StatementPrinter statementPrinter;

    public Account(Calendar calendar, TransactionRepo transactionRepo, StatementPrinter statementPrinter) {
        this.calendar = calendar;
        this.transactionRepo = transactionRepo;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        String today = calendar.todayAsString();
        this.transactionRepo.save(new Transaction(amount, today));
    }

    public void withdraw(int amount) {
        String today = calendar.todayAsString();
        this.transactionRepo.save(new Transaction(-amount, today));
    }

    public void printStatement() {
        this.statementPrinter.print(
                this.transactionRepo.allTransactions()
        );
    }
}
