package hu.training.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CurrencyRatesMock {
	private static final Map<Currency, CurrencyRate> currencyRates;
	static {
		currencyRates = new HashMap<>();
		currencyRates.put(Currency.EUR, new CurrencyRate(308.66, 326.45));
		currencyRates.put(Currency.USD, new CurrencyRate(270.57, 286.16));
		currencyRates.put(Currency.GBP, new CurrencyRate(356.09, 376.60));
	}
	public static double getCurrencyBuyingRate(Currency currency) {
		return currencyRates.get(currency).getBuyingRate();
	}
	public static double getCurrencySellingRate(Currency currency) {
		return currencyRates.get(currency).getSellingRate();
	}
	public static Map<Currency, Double> getAllCurrencyBuyingRate() {
		return currencyRates.entrySet().stream().collect(
                Collectors.toMap(x -> x.getKey(), x -> x.getValue().getBuyingRate()));
	}
	public static Map<Currency, Double> getAllCurrencySellingRate() {
		return currencyRates.entrySet().stream().collect(
                Collectors.toMap(x -> x.getKey(), x -> x.getValue().getSellingRate()));
	}
}
