package BankAccount;

public class BankAccount {

    private static int accountCount = 0;
    private static double interestRate = 0.02;
    private int id;
    private double balance;

    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public BankAccount() {
        accountCount++;
        this.id = accountCount;
        balance = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    double getInterest(int year) {
        return BankAccount.interestRate * year * this.balance;
    }
}
