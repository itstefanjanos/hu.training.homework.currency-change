package hu.training.homework;

public interface CurrencyChangeService {
	double buy(double amount, Currency expectedCurrency);
	double sell(double amount, Currency currentCurrency);
}
