package ro.ase.csie.cts.g1094.cc.assignment;

public class Account {
	public double loanValue, interestRate;	
	public int daysActive, accountType;
	public static final int	STANDARD=0, BUDGET=1, PREMIUM=2, SUPER_PREMIUM=3;
	public static final double BROKER_FEE = .0125; 

	public double getLoanValue() {
		System.out.println("The loan value is " + this.loanValue);
		return this.loanValue;
	}

	public double getRate() {
		System.out.println("The rate is "+interestRate);
		return this.interestRate;
	}

	//must have method - the lead has requested it in all classes
	public double getMonthlyRate() {
		return this.loanValue * this.interestRate;
	}

	public void setLoanValue(double value) throws Exception {
		if( value < 0 ) {
			throw new Exception();
		} else {
			this.loanValue = value;
		}
	}	

	@Override
	public String toString() {
		return "Loan: " + this.loanValue + "; rate: " + this.interestRate + "; days active:" + this.daysActive + "; Type: " + this.accountType + ";";
	}

	public void print() {
		int vb = 10;
		System.out.println("This is an account");
	}

	public static double computeTotalFee(Account[] accounts) {
		double totalFee = 0.0;
		Account	account;
		int temp = 365;
		
		for	(int i=0; i < accounts.length; i++)	{
			account = accounts[i];
			
			if( account.accountType == Account.PREMIUM || account.accountType == Account.SUPER_PREMIUM ) {
				totalFee += BROKER_FEE * (account.loanValue * Math.pow(account.interestRate, (account.daysActive / 365)) - account.loanValue);	//	interest-principal
			}				
		}
		
		return	totalFee;
	}

	public Account(double value, double rate, int type) throws Exception {
		if( value < 0) {
			throw new Exception();
		} else {
			this.loanValue = value;
		}
		
		this.interestRate = rate;
		this.accountType = type;
	}
}
