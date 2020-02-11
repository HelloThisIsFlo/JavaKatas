package BankKataJava;

public class Account {
    private Calendar calendar;
    private TransactionRepo transactionRepo;

    public Account(Calendar calendar, TransactionRepo transactionRepo) {
        this.calendar = calendar;
        this.transactionRepo = transactionRepo;
    }

    public void deposit(int amount) {
        String today = calendar.todayAsString();
        this.transactionRepo.save(new Transaction(amount, today));
    }

    public void withdraw(int amount) {

    }

    public void printStatement() {
    }
}
