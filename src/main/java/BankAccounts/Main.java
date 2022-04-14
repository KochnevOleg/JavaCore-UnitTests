package BankAccounts;

public class Main {
    public static void main(String[] args) {
        Account checkingAccount = new CheckingAccount("'Checking Account'", 45987.34);
        Account savingAccount = new SavingAccount("'Saving account'", 285592.98);
        CreditAccount creditAccount = new CreditAccount("'Credit Account'", -78290.5);

        checkingAccount.pay(12538.45);
        checkingAccount.transaction(298390.87, creditAccount);
        checkingAccount.add(36821.9);
        creditAccount.getBalance();
        System.out.println();

        savingAccount.pay(34523.43);
        savingAccount.transaction(89123.65, checkingAccount);
        savingAccount.add(19203.20);
        checkingAccount.getBalance();
        System.out.println();

        creditAccount.pay(45125);
        creditAccount.transaction(90435.65, savingAccount);
        creditAccount.add(10983.43);
        savingAccount.getBalance();
    }
}
