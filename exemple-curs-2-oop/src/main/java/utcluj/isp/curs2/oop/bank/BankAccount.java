/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utcluj.isp.curs2.oop.bank;

public class BankAccount {
    
    // instance variables
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    
    // constructor
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    
    public double getBalance(){
        return balance;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    // instance methods
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }
    
    public String displayAccountInfo() {
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder name: " + accountHolderName);
        System.out.println("Balance: $" + balance);
        return "Account number: " + accountNumber + "\n"
            + "Account holder name: " + accountHolderName + "\n"
            + "Balance: $" + balance + "\n";
    }
}