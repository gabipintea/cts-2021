package cts.pintea.gabriel.g1094.pattern.adapter;

public class BankProcessor implements IBankProcessor {

	@Override
	public void bankTransaction(String sourseAccount, String destinationAccount, double value, String currency) {
		System.out.println("Transaction executed by bank");
		
	}

	@Override
	public void bankExchangeTransaction(String sourseAccount, String destinationAccount, double value,
			String sourseCurrency, String destinationCurrency, double exchangeRate) {
		System.out.println("Exchange transaction with bank exchange rate: " + exchangeRate);
		
	}
}
