package BankAccounts;

public class CreditAccount extends Account {

    public CreditAccount(String name, double balance) {
        super(name, balance);
    }

    public String toString() {
        return name;
    }

    public void pay(double sum) {
        if (this.balance + sum <= 0) {
            System.out.println("Your payment make successfully. Credit account balance: " + (this.balance + sum));
        } else {
            System.out.println("This operation is impossible");
        }
    }

    public boolean transaction(double sum, Account account) {
        if (this.balance + sum <= 0) {
            this.balance -= sum;
            account.balance += sum;
            System.out.println("Transaction to " + account + " has been successful. Saving account balance is: " + this.balance);
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }

    public boolean add(double sum) {
        if (this.balance + sum <= 0) {
            this.balance += sum;
            System.out.println("Balance was replenished. Checking account balance is: " + this.balance);
            return true;
        }
        return false;
    }

    public double getBalance() {
        System.out.println(this.balance);
        return this.balance;
    }
}
