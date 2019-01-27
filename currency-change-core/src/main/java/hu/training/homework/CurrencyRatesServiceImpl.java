package hu.training.homework;

import java.util.Map;

public class CurrencyRatesServiceImpl implements CurrencyRatesService{
	private final CurrencyRates currencyRates;
	public CurrencyRatesServiceImpl() {
		currencyRates = new CurrencyRatesMock();
	}
	@Override
	public Map<Currency, Double> getAllCurrencyBuyingRate() {
		return currencyRates.getAllCurrencyBuyingRate();
	}

	@Override
	public Map<Currency, Double> getAllCurrencySellingRate() {
		return currencyRates.getAllCurrencySellingRate();
	}

	
	
}
