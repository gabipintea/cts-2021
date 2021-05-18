package cts.pintea.gabriel.g1094.pattern.factorymethod;

public class CreditAccount extends BankAccount {
	
	int installmentsNo;
	double creditLimit;
	

	public CreditAccount(double Balance, String Id, int installmentsNo, double creditLimit) {
		super(Balance, Id);
		this.installmentsNo = installmentsNo;
		this.creditLimit = creditLimit;
	}

}
