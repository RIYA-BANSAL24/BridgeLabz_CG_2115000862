import java.util.*;
abstract class BankAccount{
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getHolderName(){
        return holderName;
    }
    public double getBalance(){
        return balance;
    }
    
    private void setBalance(double balance){
        this.balance = balance;
    }
    public void deposit(double amount){
        System.out.println("Deposited Amount: " + amount + "Update Balance: " + (balance += amount));
    }
    public void withdraw(double amount){
        System.out.println("Withdrawal amount: " + amount + " Balance after withdrawing: " + (balance -= amount));
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder's Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

interface Loanable{
    public void applyForLoan(double amount);
    public double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 1.25;

    public SavingsAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan of " + amount + " applied.");
    }

    public double calculateLoanEligibility() {
        return getBalance() * 2;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double Limit = 1000;

    public CurrentAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    public double calculateInterest() {
        return 0;
    }

    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan of " + amount + " applied.");
    }

    public double calculateLoanEligibility() {
        return getBalance() + Limit;
    }
}
public class BankingSystem {
    public static void processAccounts(List<BankAccount> acc) {
        for (BankAccount account : acc) {
            account.displayAccountDetails();
            double interest = account.calculateInterest();
            System.out.println("Interest Earned: " + interest);

            if (account instanceof Loanable) {
                Loanable loanableAccount = (Loanable) account;
                double eligibility = loanableAccount.calculateLoanEligibility();
                System.out.println("Loan Eligibility: " + eligibility);
            }
        }
    }

    public static void main(String[] args){
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("RIYABANS5825", "Riya Bansal", 5000));
        accounts.add(new CurrentAccount("RAUHL45678", "Rahul Chaudhary", 3000));

        processAccounts(accounts);
    }
}
