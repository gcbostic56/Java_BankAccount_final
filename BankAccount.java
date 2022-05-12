import java.util.Scanner;

public class BankAccount {
    private String AccountHolderName;
    private double Balance;
    private int AccountNumber;
    public static Scanner scanner = new Scanner(System.in);

    public BankAccount(String customerName, double customerBalance, int acctNumber) {
        this.Balance = customerBalance;
        this.AccountHolderName = customerName;
        this.AccountNumber = acctNumber;
    }
    public BankAccount() {
    System.out.println("What is the name of the account?");
    String name = scanner.nextLine();
    System.out.println("What is the beginning balance of the account?");
    double balance = scanner.nextDouble();
    scanner.nextLine();
    this.setBalance(balance);
    this.setName(name);
    
    }
    public double transfer(BankAccount obj, double amount) {
        return obj.deposit(this.withdrawal(amount));
    }
    public double setBalance(double pourMoney) {
        this.Balance += pourMoney;
        return pourMoney;
    }
    public void setAccountNumber(int newAccountNumber) {
        this.AccountNumber = newAccountNumber;
    }
    public String setName(String name) {
        this.AccountHolderName = name;
        return name;
    }
    public double deposit(double amount) {
        this.Balance += amount;
        return amount;
    }
    public String GetName() {
        return this.AccountHolderName;
    }
    
    public double withdrawal(double amount) {
        this.Balance -= amount;
        return amount;
    }
    public double printBalance() {
        return this.Balance;
    }
    public void printAccount() {
        System.out.println("(Account Number: "+this.AccountNumber+")"+this.AccountHolderName+ "'s account balance is: $"+this.Balance);
    }
    public String toString() {
        return "(Account Number: "+this.AccountNumber+")"+AccountHolderName+ "'s account has a balance of $" +Balance;
    }
}