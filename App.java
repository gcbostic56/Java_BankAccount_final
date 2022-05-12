import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<BankAccount> AccountLists = new ArrayList<>();
    public static int AccountNumber;
    public static void main(String[] args) throws Exception {
    BankAccount Cameron = new BankAccount("Cameron", 6000, 0);
    BankAccount Obama = new BankAccount("Barrack Obama", 500, 1);
    BankAccount Adam = new BankAccount("Adam Sandler", 100000, 2);
    AccountLists.add(Cameron);
    AccountLists.add(Obama);
    AccountLists.add(Adam);
    System.out.println("Welcome to the very fine Bank of Don Cheadle.");
    
    
    while(true) {
    System.out.println("Are you an existing customer? Enter 1 for yes or 2 for no. Enter 0 to exit.");
    int answer1 = scanner.nextInt();
    if (answer1 == 1) {
        System.out.println("What is your account number?");
        AccountNumber = scanner.nextInt();
        if (AccountNumber >= 0 && AccountNumber < AccountLists.size()) {
            mainMenu(AccountLists.get(AccountNumber));
        }
    }
    if (answer1 == 2) {
        System.out.println("Let's Make A New Account.");
        BankAccount Account1 = new BankAccount();
        Account1.setAccountNumber(AccountLists.size());
        System.out.println("Your new account number is "+AccountLists.size());
        AccountLists.add(Account1);
        for (BankAccount bank: AccountLists) {
            System.out.println(bank.toString());
        }
        continue;
    }
    if (answer1 == 0) {
        break;
    }
    }
}
    public static void mainMenu(BankAccount obj) {
    while(true) {
       System.out.println("Hello " + obj.GetName());
       System.out.println("Welcome to the Main Menu.");
       System.out.println("1. To check account balance");
       System.out.println("2. To make a withdraw");
       System.out.println("3. To make a deposit");
       System.out.println("4. To make a transfer to another account");
       System.out.println("0. To exit");
       
       int mainMenuOption = scanner.nextInt();

    if (mainMenuOption == 1) {
        double balance = obj.printBalance();
        System.out.println("The current balance is $" +balance);
        mainMenu(AccountLists.get(AccountNumber));
    }
    if (mainMenuOption == 2) {
        System.out.println("How much do you want to withdraw? Your current balance is $"+obj.printBalance());
        double withdraw = scanner.nextInt();
        if (withdraw > obj.printBalance()) {
            System.out.println("Nice try! We are going back to Main Menu.");
            mainMenu(AccountLists.get(AccountNumber));
        }
        obj.withdrawal(withdraw);
        System.out.println("Your new balance is $"+obj.printBalance());
        mainMenu(AccountLists.get(AccountNumber));
    }
    if (mainMenuOption == 3) {
        System.out.println("How much do you want to deposit? Your current balance is $"+obj.printBalance());
        double deposit = scanner.nextInt();
        obj.deposit(deposit);
        System.out.println("Your new balance is $"+obj.printBalance());
        mainMenu(AccountLists.get(AccountNumber));
    }
    if (mainMenuOption == 4) {
        System.out.println("Your current balance is $"+obj.printBalance());
        System.out.println("Please enter the account number to transfer to.");
        int otherAccount = scanner.nextInt();
        if (otherAccount > AccountLists.size()) {
            System.out.println("Please enter a valid account number.");
            mainMenu(AccountLists.get(AccountNumber));
            return;
        }
        System.out.println("Please enter the amount to transfer to account.");
        double transferAmount = scanner.nextInt();
        if (transferAmount > obj.printBalance()) {
            System.out.println("You poor people trying to pull a fast one. Back to the main menu.");
            mainMenu(AccountLists.get(AccountNumber));
        }
        obj.transfer(AccountLists.get(otherAccount), transferAmount);
        System.out.println("Your new balance is "+obj.printBalance());
        System.out.println(AccountLists.get(otherAccount).GetName()+"'s account is now "+AccountLists.get(otherAccount).printBalance());
        mainMenu(AccountLists.get(AccountNumber));
    }
    if (mainMenuOption == 0) {
        break;
    }
    break;
    }
    }
}

    

