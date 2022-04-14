package BankAccounts;

public class CheckingAccount extends Account {

    public CheckingAccount(String name, double balance) {
        super(name, balance);
    }

    public String toString() {
        return name;
    }


    public void pay(double sum) {
        if (this.balance - sum >= 0) {
            System.out.println("Your payment make successfully. Checking account balance is: " + (this.balance - sum));
        } else {
            System.out.println("Insufficient funds");
        }
    }


    public boolean transaction(double sum, Account account) {
        if (this.balance - sum >= 0) {
            this.balance -= sum;
            account.add(sum);
            System.out.println("Transaction to " + account + " has been successful. Checking account balance is: " + this.balance);
            return true;
        } else {
            System.out.println("Operation is impossible.");
            return false;
        }
    }

    public boolean add(double sum) {
        this.balance += sum;
        System.out.println("Balance was replenished. Checking account balance is: " + this.balance);
        return true;
    }

    public double getBalance() {
        System.out.println(this.balance);
        return this.balance;
    }


}
