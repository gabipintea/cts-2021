package cts.pintea.gabriel.g1094.pattern.adapter;

public class ProcessorAdapter extends BankProcessor implements IVisaProcessor {
	VisaProcessor processor = null;

	@Override
	public void transaction(String sourseAccount, String destinationAccount, double value, String currency) {
		this.processor = new VisaProcessor();
		this.processor.transaction(sourseAccount, destinationAccount, value, currency);
		
	}

	@Override
	public void transactionWithCurrencyExchange(String sourseAccount, String destinationAccount, double value,
			String sourseCurrency, String destinationCurrency) {
		this.bankExchangeTransaction(sourseAccount, destinationAccount, value, sourseCurrency, destinationCurrency, value);
		
	}
	
	

	

}
