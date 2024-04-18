package com.example.tax;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner s = new Scanner(System.in);

		System.out.println("Welcome to the Tax Payment Application");
		while (true) {
			System.out.println("Please select which tax you want to pay: \n1. Income \n2. Property\n3. Exit");
			int taxChoice = s.nextInt();
			String property = "";
			switch (taxChoice) {
			case 1: {
				property = "incomeTax";
				break;
			}
			case 2: {
				property = "propertyTax";

				break;
			}
			default: {
				System.out.println("Exiting...");
				return;
			}

			}
			Tax tax = (Tax) context.getBean(property);
		
			if (tax.isTaxPayed() && property.equals("incomeTax")) {
				System.out.println("You have already payed income tax.");
			} 
			else if(tax.isTaxPayed() && property.equals("propertyTax")) {
				System.out.println("You have already payed property tax.");
			}
			else {
				System.out.println("Please enter your Income/Property value:");

				int taxableAmount = s.nextInt();
				tax.setTaxableAmount(taxableAmount);
				tax.calculateTaxAmount();
				if (property.equals("incomeTax")) {
					
					System.out.println("you have selected income tax and your tax amount is: " + tax.getTaxAmount());

				} else if(property.equals("propertyTax")){

					System.out.println("you have selected property tax and your tax amount is: " + tax.getTaxAmount());	
				}
				while (true) {
					System.out.println("Do you want to pay the tax:\n1. Yes\n2. Exit");
					int key = s.nextInt();
					switch (key) {
					case 1: {
						tax.payTax();
						break;
					}
					
					default:
						return;
					}
					break;
				}
				
			}
			
			//System.out.println(tax.getTaxType());

		}

	}
}
