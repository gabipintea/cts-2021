package cts.pintea.gabriel.g1094.pattern.factorymethod;

public class CreditAccountFactory extends AbstractAccountFactory {

	@Override
	public BankAccount getDebitAccount(double balance, String id, boolean collectedSalary, boolean isOverdraft) {
		throw new UnsupportedOperationException("This is a credit account.");
	}

	@Override
	public BankAccount getCreditAccount(double balance, String id, int installmentsNo, double creditLimit) {
		BankAccount creditAccount = new CreditAccount(balance, id, installmentsNo, creditLimit);
		return creditAccount;
	}

}
