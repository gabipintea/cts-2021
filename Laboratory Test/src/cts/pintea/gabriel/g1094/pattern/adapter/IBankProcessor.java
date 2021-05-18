package cts.pintea.gabriel.g1094.pattern.adapter;

public interface IBankProcessor {
	public void bankTransaction(String sourseAccount, String destinationAccount, double value, String currency);
	public void bankExchangeTransaction(String sourseAccount, String destinationAccount, double value,
            String sourseCurrency, String destinationCurrency, double exchangeRate);

}
