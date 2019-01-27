package hu.training.homework;

import java.util.Map;

public interface CurrencyRates {
	double getCurrencyBuyingRate(Currency currency);
	double getCurrencySellingRate(Currency currency);
	Map<Currency, Double> getAllCurrencyBuyingRate();
	Map<Currency, Double> getAllCurrencySellingRate();
}
