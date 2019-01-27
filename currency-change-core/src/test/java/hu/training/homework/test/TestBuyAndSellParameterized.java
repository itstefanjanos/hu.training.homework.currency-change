package hu.training.homework.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import hu.training.homework.Currency;
import hu.training.homework.CurrencyChangeService;
import hu.training.homework.CurrencyChangeServiceImpl;
import hu.training.homework.CurrencyRatesMock;
import hu.training.homework.CurrencyRatesService;
import hu.training.homework.CurrencyRatesServiceImpl;

@RunWith(Parameterized.class)
public class TestBuyAndSellParameterized {
	
	public CurrencyChangeService currencyChangeService = null;
	
	@Before
	public void init() {
		currencyChangeService = new CurrencyChangeServiceImpl();
	}
	
	@Parameters(name= "{index}: {0}{3} {1}HUF {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        	{ 308.66, 1.0, "buy", Currency.EUR },
        	{ 270.57, 1.0, "buy", Currency.USD },
        	{ 356.09, 1.0, "buy", Currency.GBP },
        	{ 617.32, 2.0, "buy", Currency.EUR },
        	{ 541.14, 2.0, "buy", Currency.USD },
        	{ 712.18, 2.0, "buy", Currency.GBP },
        	{ 154.33, 0.5, "buy", Currency.EUR },
        	{ 135.29, 0.5, "buy", Currency.USD },
        	{ 178.05, 0.5, "buy", Currency.GBP },
        	{ 1.0, 326.45, "sell", Currency.EUR },
        	{ 1.0, 286.16, "sell", Currency.USD },
        	{ 1.0, 376.60, "sell", Currency.GBP },
        	{ 2.0, 652.90, "sell", Currency.EUR },
        	{ 2.0, 572.32, "sell", Currency.USD },
        	{ 2.0, 753.20, "sell", Currency.GBP },
        	{ 0.5, 163.23, "sell", Currency.EUR },
        	{ 0.5, 143.08, "sell", Currency.USD },
        	{ 0.5, 188.30, "sell", Currency.GBP }	});
    }
    @Parameter(0)
    public Double currentAmount;

    @Parameter(1)
    public Double expectedAmount;
    
    @Parameter(2)
    public String command;
    
    @Parameter(3) 
    public Currency currency;
    
	@Test
	public void testBuyAndSell() {
		if ("buy".equals(command)) {
			assertEquals(expectedAmount, currencyChangeService.buy(currentAmount, currency), 0.01);
		}
		if ("sell".equals(command)) {
			assertEquals(expectedAmount, currencyChangeService.sell(currentAmount, currency), 0.01);
		}
	}
}
