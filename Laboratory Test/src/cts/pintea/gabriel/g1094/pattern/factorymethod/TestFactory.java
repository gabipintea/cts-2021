package cts.pintea.gabriel.g1094.pattern.factorymethod;

public class TestFactory {
	
	public static void main(String[] args) {
		Banker banker = new Banker("John");
		banker.openAccount(new DebitAccountFactory().getDebitAccount(100.00, "acc1", true, false));
		banker.openAccount(new CreditAccountFactory().getCreditAccount(5000.0, "acc2", 7, 6000.0));
		banker.openAccount(new CreditAccountFactory().getCreditAccount(3000.0, "acc3", 7, 2000.0));		
	}

}
