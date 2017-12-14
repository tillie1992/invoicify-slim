package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;

//This needs to be an entity
@Entity
public class RateBasedBillingRecord extends BillingRecord {

	// This needs a double field named rate
	private double rate;

	// This needs a double field named quantity
	private double quantity;

	// This needs to override the getTotal() method
	// and return the product of the rate and quantity
	@Override
	public double getTotal() {

		return (rate * quantity);
	}

	// This needs getters and setters
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
