package ro.ase.csie.cts.g1094.cc.assignment.services;

import ro.ase.csie.cts.g1094.cc.assignment.exceptions.InvalidDaysException;
import ro.ase.csie.cts.g1094.cc.assignment.exceptions.InvalidLoanException;

public interface ValidatorServiceInterface {
	public void validateLoanValue(Double loanValue) throws InvalidLoanException;
	public void validateActiveDays(Integer daysActive) throws InvalidDaysException;

}
