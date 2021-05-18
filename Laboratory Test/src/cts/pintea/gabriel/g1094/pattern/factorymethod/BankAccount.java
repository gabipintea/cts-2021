package cts.pintea.gabriel.g1094.pattern.factorymethod;

public abstract class BankAccount {
    double balance;
    String id;

    public BankAccount(double Balance, String Id) {
        balance = Balance;
        id = Id;
    }
}
