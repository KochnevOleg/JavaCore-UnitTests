package BankAccounts;

public class SavingAccount extends Account {

    public SavingAccount(String name, double balance) {
        super(name, balance);
    }

    public String toString() {
        return name;
    }

    public void pay(double sum) {
        System.out.println("This operation is impossible");
    }

    public boolean transaction(double sum, Account account) {
        if (this.balance - sum >= 0) {
            this.balance -= sum;
            account.add(sum);
            System.out.println("Transaction to " + account + " has been successful. Saving account balance is: " + this.balance);
            return true;
        } else {
            System.out.println("Operation is impossible.");
            return false;
        }
    }

    public boolean add(double sum) {
        this.balance += sum;
        System.out.println("Balance was replenished. Saving account balance is: " + this.balance);
        return true;
    }

    public double getBalance() {
        System.out.println(this.balance);
        return this.balance;

    }
}
