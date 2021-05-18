package cts.pintea.gabriel.g1094.pattern.factorymethod;

public class DebitAccount extends BankAccount {
	
	boolean collectedSalary;
	boolean isOverdraft;

	public DebitAccount(double Balance, String Id, boolean collectedSalary, boolean isOverdraft) {
		super(Balance, Id);
		this.collectedSalary = collectedSalary;
		this.isOverdraft = isOverdraft;
	}
	

}
