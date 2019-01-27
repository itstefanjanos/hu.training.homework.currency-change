package hu.training.homework;

import java.util.Map;

public interface CurrencyRatesService {
	Map<Currency, Double> getAllCurrencyBuyingRate();
	Map<Currency, Double> getAllCurrencySellingRate();
}
