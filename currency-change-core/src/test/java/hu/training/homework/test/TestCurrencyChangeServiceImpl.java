package hu.training.homework.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

import hu.training.homework.Currency;
import hu.training.homework.CurrencyChangeService;
import hu.training.homework.CurrencyChangeServiceImpl;
import hu.training.homework.CurrencyRate;
import hu.training.homework.CurrencyRatesMock;

public class TestCurrencyChangeServiceImpl {
	
	public CurrencyChangeService currencyChangeService = null;
	@Before
	public void init() {
		currencyChangeService = new CurrencyChangeServiceImpl();
	}
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeOrZeroAmountBuying() {
		currencyChangeService.buy(-1.0, null);
		currencyChangeService.buy(0.0, null);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeOrZeroAmountSelling() {
		currencyChangeService.sell(-1.0, null);
		currencyChangeService.sell(0.0, null);
	}
	@Test(expected = NoSuchElementException.class)
	public void testNullCurrencyBuy() {
		currencyChangeService.buy(1.0, null);
	}
	@Test(expected = NoSuchElementException.class)
	public void testNullCurrencySell() {
		currencyChangeService.sell(1.0, null);
	}
	@Test
	public void testBuyOneEur() {
		double oneEur = CurrencyRatesMock.getCurrencyBuyingRate(Currency.EUR);
		assertEquals(1, currencyChangeService.buy(oneEur, Currency.EUR), 0.01);
	}
	@Test
	public void testBuyOneUsd() {
		double oneUsd = CurrencyRatesMock.getCurrencyBuyingRate(Currency.USD);
		assertEquals(1, currencyChangeService.buy(oneUsd, Currency.USD), 0.01);
	}
	@Test
	public void testBuyOneGbp() {
		double oneGbp = CurrencyRatesMock.getCurrencyBuyingRate(Currency.GBP);
		assertEquals(1, currencyChangeService.buy(oneGbp, Currency.GBP), 0.01);
	}
	@Test
	public void testSellOneEur() {
		double oneEur = CurrencyRatesMock.getCurrencySellingRate(Currency.EUR);
		assertEquals(oneEur, currencyChangeService.sell(1, Currency.EUR), 0.01);
	}
	@Test
	public void testSellOneUsd() {
		double oneUsd = CurrencyRatesMock.getCurrencySellingRate(Currency.USD);
		assertEquals(oneUsd, currencyChangeService.sell(1, Currency.USD), 0.01);
	}
	@Test
	public void testSellOneGbp() {
		double oneGbp = CurrencyRatesMock.getCurrencySellingRate(Currency.GBP);
		assertEquals(oneGbp, currencyChangeService.sell(1, Currency.GBP), 0.01);
	}
	@Test
	public void testGetAllCurrencyBuyingRate() {
		Map<Currency, Double> currencyRates = new HashMap<>();
		currencyRates.put(Currency.EUR, 308.66);
		currencyRates.put(Currency.USD, 270.57);
		currencyRates.put(Currency.GBP, 356.09);
		
		assertThat(CurrencyRatesMock.getAllCurrencyBuyingRate(), is(currencyRates));
	}
	@Test
	public void testGetAllCurrencySellingRate() {
		Map<Currency, Double> currencyRates = new HashMap<>();
		currencyRates.put(Currency.EUR, 326.45);
		currencyRates.put(Currency.USD, 286.16);
		currencyRates.put(Currency.GBP, 376.60);
		
		assertThat(CurrencyRatesMock.getAllCurrencySellingRate(), is(currencyRates));
	}
}
