package ro.ase.csie.cts.g1094.cc.assignment.services;

public class CreditService implements CreditServiceInterface {

	@Override
	public double getMonthlyRate(Double loanValue, Double interestRate) {
		return loanValue * interestRate;
	}

}
