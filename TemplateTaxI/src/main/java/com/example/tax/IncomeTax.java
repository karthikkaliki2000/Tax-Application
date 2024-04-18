package com.example.tax;

public class IncomeTax implements Tax {
	 double taxableAmount;
	 double taxAmount;
	 boolean isTaxPayed;
	
	public IncomeTax() {
		this.isTaxPayed=false;
	}
	@Override
	public void setTaxableAmount(int amount) {
		// TODO Auto-generated method stub
		this.taxableAmount = amount;

	}

	@Override
	public void calculateTaxAmount() {
		// TODO Auto-generated method stub
		double tax = 0;
		if(this.taxableAmount<=300000) {
			tax=0;
		}else if (this.taxableAmount >300000 && this.taxableAmount <= 600000) {
			tax = 0.05;
		} else if (this.taxableAmount > 600000 && this.taxableAmount <=900000) {
			tax = 0.10;
		} else if (this.taxableAmount > 900000 && this.taxableAmount <=1200000) {
			tax = 0.15;
		}else if (this.taxableAmount > 1200000 && this.taxableAmount <=1500000) {
			tax = 0.20;
		}else if (this.taxableAmount > 1500000) {
			tax = 0.30;
		}
		//System.out.println("taxAmount"+tax+" "+this.taxableAmount);
		this.taxAmount=tax*this.taxableAmount;

	}

	@Override
	public double getTaxAmount() {
		// TODO Auto-generated method stub
		return this.taxAmount;
	}

	@Override
	public String getTaxType() {
		// TODO Auto-generated method stub
		return "income";
	}

	@Override
	public boolean isTaxPayed() {
		// TODO Auto-generated method stub
		return this.isTaxPayed;
	}

	@Override
	public void payTax() {
		// TODO Auto-generated method stub
		System.out.println("Hi, your income tax is paid.");
		this.isTaxPayed=true;

	}
	/*
	 * 1. Create the following attributes. a. taxableAmount (double) b. taxAmount
	 * (double) c. isTaxPayed (boolean) 2. Make this class an implementation of Tax
	 * interface and override the interface methods. 3. Using constructor initialize
	 * the isTaxPayed boolean false.
	 */

}
