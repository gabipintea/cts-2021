package ro.ase.csie.cts.g1094.cc.assignment.services;


public interface ValidatorServiceInterface {
	public void validateLoanValue(Double loanValue) throws UnsupportedOperationException;
	public void validateActiveDays(Integer daysActive) throws UnsupportedOperationException;

}
