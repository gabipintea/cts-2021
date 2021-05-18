package cts.pintea.gabriel.g1094.pattern.adapter;

public class VisaProcessor implements IVisaProcessor {

	@Override
	public void transaction(String sourseAccount, String destinationAccount, double value, String currency) {
		System.out.println("Transaction processed by Visa");
		
	}

	@Override
	public void transactionWithCurrencyExchange(String sourseAccount, String destinationAccount, double value,
			String sourseCurrency, String destinationCurrency) {
		System.out.println("Exchange transaction processed by Visa");
		
	}

}
