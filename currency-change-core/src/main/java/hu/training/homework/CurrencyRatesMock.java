package hu.training.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
//import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CurrencyRatesMock implements CurrencyRates {
	private final Map<Currency, CurrencyRate> currencyRates;
	
	public CurrencyRatesMock() {
		super();
		currencyRates = new HashMap<>();
		currencyRates.put(Currency.EUR, new CurrencyRate(308.66, 326.45));
		currencyRates.put(Currency.USD, new CurrencyRate(270.57, 286.16));
		currencyRates.put(Currency.GBP, new CurrencyRate(356.09, 376.60));
	}
	
	public double getCurrencyBuyingRate(Currency currency) {
		if (currency == null || !currencyRates.containsKey(currency)) {
			throw new NoSuchElementException();
		}
		return currencyRates.get(currency).getBuyingRate();
	}
	public double getCurrencySellingRate(Currency currency) {
		if (currency == null || !currencyRates.containsKey(currency)) {
			throw new NoSuchElementException();
		}
		return currencyRates.get(currency).getSellingRate();
	}
	public Map<Currency, Double> getAllCurrencyBuyingRate() {
		return currencyRates.entrySet().stream().collect(
                Collectors.toMap(x -> x.getKey(), x -> x.getValue().getBuyingRate()));
	}
	public Map<Currency, Double> getAllCurrencySellingRate() {
		return currencyRates.entrySet().stream().collect(
                Collectors.toMap(x -> x.getKey(), x -> x.getValue().getSellingRate()));
	}
}
