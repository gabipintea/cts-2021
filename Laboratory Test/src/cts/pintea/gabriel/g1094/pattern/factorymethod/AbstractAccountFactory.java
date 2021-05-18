package cts.pintea.gabriel.g1094.pattern.factorymethod;

public abstract class AbstractAccountFactory {
	
	public abstract BankAccount getDebitAccount(double balance, String id, boolean collectedSalary, boolean isOverdraft);
	public abstract BankAccount getCreditAccount(double balance, String id, int installmentsNo, double creditLimit);

}
