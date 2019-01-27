package hu.training.homework;

public interface CurrencyChangeService {
	double buy(double amount, Currency expectedCurreny);
	double sell(double amount, Currency currentCurreny);
}
