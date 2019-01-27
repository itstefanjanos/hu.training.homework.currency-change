package hu.training.homework;

public class CurrencyRate {

	public double getBuyingRate() {
		return buyingRate;
	}

	public double getSellingRate() {
		return sellingRate;
	}
	
	private final double buyingRate;
	private final double sellingRate;
	
	public CurrencyRate(double buyingRate, double sellingRate) {
		super();
		this.buyingRate = buyingRate;
		this.sellingRate = sellingRate;
	}
	
}

