package ro.ase.csie.cts.g1094.cc.assignment;

import java.util.ArrayList;

public class TestAssignment {
	
	public static ArrayList<Account> accounts = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		
		Account account = new Account(100.0, 0.01, 800, AccountType.PREMIUM);
		
		accounts.add(account);
		System.out.println(Account.computeTotalFee(accounts));		

	}

}
