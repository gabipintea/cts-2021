package cts.pintea.gabriel.g1094.pattern.factorymethod;

public class Banker {
	String bankerName;
	BankAccount newAccount;
	
	public Banker(String bankerName) {
		super();
		this.bankerName = bankerName;
	}
	
	public void openAccount(BankAccount newAccount) {
		this.newAccount = newAccount;
		System.out.println("New account opened");
	}
	
	

}
