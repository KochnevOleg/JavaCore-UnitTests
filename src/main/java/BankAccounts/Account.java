package BankAccounts;

public abstract class Account {

    String name;
    double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public abstract void pay(double sum);

    public abstract boolean transaction(double sum, Account account);

    public abstract boolean add(double sum);

    public abstract double getBalance();
}
