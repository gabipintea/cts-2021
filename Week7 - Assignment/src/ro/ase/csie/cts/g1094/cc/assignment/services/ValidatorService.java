package ro.ase.csie.cts.g1094.cc.assignment.services;

public class ValidatorService implements ValidatorServiceInterface {

	@Override
	public void validateLoanValue(Double loanValue) throws UnsupportedOperationException {
		if( loanValue < 0 ) {
			throw new UnsupportedOperationException("Loan value must be positive");
		}
		
	}

	@Override
	public void validateActiveDays(Integer daysActive) throws UnsupportedOperationException {
		if( daysActive < 0 ) {
			throw new UnsupportedOperationException("Active days must be a positive value");
		}
		
	}

}
