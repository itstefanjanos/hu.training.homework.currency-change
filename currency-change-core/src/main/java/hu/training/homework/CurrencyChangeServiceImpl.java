package hu.training.homework;

public class CurrencyChangeServiceImpl implements CurrencyChangeService {
	private final CurrencyRatesMock currencyRatesMock;
	public CurrencyChangeServiceImpl() {
		currencyRatesMock = new CurrencyRatesMock();
	}
	@Override
	public double buy(double amount, Currency expectedCurrency) throws IllegalArgumentException {
		if (amount <= 0.0) {
			throw new IllegalArgumentException("The amount must be a positive number!");
		}
		return amount / currencyRatesMock.getCurrencyBuyingRate(expectedCurrency);
	}

	@Override
	public double sell(double amount, Currency currentCurrency) throws IllegalArgumentException {
		if (amount <= 0.0) {
			throw new IllegalArgumentException("The amount must be a positive number!");
		}
		return currencyRatesMock.getCurrencySellingRate(currentCurrency) / amount;
	}

}
