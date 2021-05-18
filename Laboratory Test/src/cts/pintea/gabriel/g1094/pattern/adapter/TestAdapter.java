package cts.pintea.gabriel.g1094.pattern.adapter;

public class TestAdapter {
	 static final double BANK_RATE = 1.21;

	public static void main(String[] args) {
		
		IVisaProcessor processor = new ProcessorAdapter();
		processor.transaction("Source", "Destination", 100.00, "EUR");
		processor.transactionWithCurrencyExchange("Source", "Destination", 100.00*BANK_RATE, "EUR", "RON");
		processor.transactionWithCurrencyExchange("Source", "Destination", 90.00*BANK_RATE, "EUR", "RON");
		processor.transaction("Source", "Destination", 50.00, "RON");
	}

}
