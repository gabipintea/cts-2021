package ro.ase.csie.cts.g1094.cc.assignment;

public class TestAssignment {

	public static void main(String[] args) throws Exception {
		
		Account account = new Account(1000.0, 2.0, 200, AccountType.BUDGET);
		
		System.out.println(account.toString());

	}

}
