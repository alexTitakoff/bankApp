/**
 * Created by alex on 09/04/2017.
 */
public class Account {
    private  double balance;
    private double interest;
    private int accountNumber;
    private static int numberOfAccount = 1000000;


    Account() {
        accountNumber = numberOfAccount++; 
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
