package hu.training.homework;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CurrencyChangeApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String command = null;
		Boolean validCurrency = false;
		Boolean validAmount = false;
		Currency currency = null;
		Double amount = null;
		CurrencyChangeService currencyChangeService = null;
		Double convertedAmount = null;
		do {
			System.out.print("Please type sell or buy command: ");
		} while (!"sell".equals(command = scanner.nextLine().toLowerCase()) 
				&& !"buy".equals(command));
		CurrencyRatesService currencyRatesService = new CurrencyRatesServiceImpl();
		if ("sell".equals(command)) {
			System.out.format("Selling Rates:\n%s\n",
					ConvertCurrencyRatesToString(
							currencyRatesService.getAllCurrencySellingRate()));
		}
		else if ("buy".contains(command)) {
			System.out.format("Buying Rates:\n%s\n",
					ConvertCurrencyRatesToString(
							currencyRatesService.getAllCurrencyBuyingRate()));
		}
		
		do {
			System.out.format("Please type Curreny do you %s and Amount(ex.: EUR 200): ", ("buy".equals(command)?"need":"have"));
			try {
				currency = Currency.valueOf(scanner.next().toUpperCase());
				validCurrency = true;
				amount = scanner.nextDouble();
				validAmount = true;
			} catch (IllegalArgumentException | InputMismatchException e) {
				while(scanner.hasNext())
				    scanner.next();
			}
		} while (!(validCurrency && validAmount));
		
		currencyChangeService = new CurrencyChangeServiceImpl();
		
		convertedAmount = "buy".equals(command)?
				currencyChangeService.buy(amount, currency):
					currencyChangeService.sell(amount, currency);
				
		
		System.out.format("Converted currency: %.2f%s\n", convertedAmount, 
				"buy".equals(command)?currency:"HUF");
		
		scanner.close();
	}
	
	private static String ConvertCurrencyRatesToString(Map<Currency, Double> currencyRates) {
		return currencyRates.entrySet().stream()
				.map(currencyRate -> 
					String.format("%s: %.2fHUF", 
							currencyRate.getKey(), currencyRate.getValue()))
				.collect(Collectors.joining("\n"));
	}

}
