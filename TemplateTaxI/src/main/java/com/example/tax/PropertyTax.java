package com.example.tax;

public class PropertyTax implements Tax{
	double taxableAmount;
	double taxAmount;
	boolean isTaxPayed;
	public PropertyTax() {
		this.isTaxPayed=false;
	}
	@Override
	public void setTaxableAmount(int amount) {
		// TODO Auto-generated method stub
	
		this.taxableAmount=amount;
		
	}

	@Override
	public void calculateTaxAmount() {
		// TODO Auto-generated method stub
		this.taxAmount=0.05*this.taxableAmount;
		
		
	}

	@Override
	public double getTaxAmount() {
		return this.taxAmount;
	}

	@Override
	public String getTaxType() {
		return "property";
	}

	@Override
	public boolean isTaxPayed() {
		// TODO Auto-generated method stub
		return this.isTaxPayed;
	}

	@Override
	public void payTax() {
		// TODO Auto-generated method stub
				System.out.println("Hi, your property tax is paid.");
				this.isTaxPayed=true;
	}
   
}
