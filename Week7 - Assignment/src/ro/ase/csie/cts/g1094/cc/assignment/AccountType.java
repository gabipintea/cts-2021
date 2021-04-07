package ro.ase.csie.cts.g1094.cc.assignment;

public enum AccountType {
	STANDARD(.0), BUDGET(.0), PREMIUM(.0125), SUPER_PREMIUM(.0125);
	
	private final double BROKER_FEE;
	
	private AccountType(double fee) {
		this.BROKER_FEE = fee;
	}
	
	public double getBrokerFee() {
		return this.BROKER_FEE;
	}

}
