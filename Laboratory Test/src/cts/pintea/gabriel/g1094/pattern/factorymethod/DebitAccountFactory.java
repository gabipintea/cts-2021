package cts.pintea.gabriel.g1094.pattern.factorymethod;

public class DebitAccountFactory extends AbstractAccountFactory {

	@Override
	public BankAccount getDebitAccount(double balance, String id, boolean collectedSalary, boolean isOverdraft) {
		BankAccount debitAccount = new DebitAccount(balance, id, collectedSalary, isOverdraft);
		return debitAccount;
	}

	@Override
	public BankAccount getCreditAccount(double balance, String id, int installmentsNo, double creditLimit) {
		throw new UnsupportedOperationException("This is a debit account");
	}

}
