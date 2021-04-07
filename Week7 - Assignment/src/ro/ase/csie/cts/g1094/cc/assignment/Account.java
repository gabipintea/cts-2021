package ro.ase.csie.cts.g1094.cc.assignment;

import java.util.ArrayList;

import ro.ase.csie.cts.g1094.cc.assignment.exceptions.InvalidDaysException;
import ro.ase.csie.cts.g1094.cc.assignment.exceptions.InvalidLoanException;
import ro.ase.csie.cts.g1094.cc.assignment.services.LeadInterface;

public class Account implements LeadInterface{
	protected double loanValue, interestRate;	
	protected int daysActive;
	AccountType accountType;
	
	public static final int YEAR_DAYS = 365;

	public double getLoanValue() {
		return this.loanValue;
	}

	public double getRate() {
		return this.interestRate;
	}
	
	@Override
	public double getMonthlyRate() {
		return this.loanValue * this.interestRate;
	}

	public void setLoanValue(Double value) throws InvalidLoanException {
		if( value < 0 ) {
			throw new InvalidLoanException("Loan value must be positive");
		} else {
			this.loanValue = value;
		}
	}	

	@Override
	public String toString() {
		return "Loan: " + this.loanValue 
				+ "; rate: " + this.interestRate 
				+ "; days active:" + this.daysActive 
				+ "; Type: " + this.accountType + ";";
	}
	
	private double computeInterest() {
		return this.loanValue * Math.pow(this.interestRate, (this.daysActive / YEAR_DAYS));
	}
	
	private double computeFee() {
		return this.accountType.getBrokerFee() * (this.computeInterest() - this.loanValue);
	}

	public static double computeTotalFee(ArrayList<Account> accounts) {
		double totalFee = 0.0;
		
		for	(Account account : accounts) {
			totalFee += account.computeFee();				
		}
		
		return	totalFee;
	}

	public Account(Double loanValue, Double interestRate, Integer daysActive, AccountType accountType) throws InvalidDaysException {
		setLoanValue(loanValue);
		if( daysActive < 0 ) {
			throw new InvalidDaysException("Active days must be a positive value");
		}
		this.daysActive = daysActive;
		this.interestRate = interestRate;		
		this.accountType = accountType;
	}	
}
