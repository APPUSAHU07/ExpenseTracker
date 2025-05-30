package com.expenseTrackerProj;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
	
	private TransactionType type;
	private Category category;
	private double amount;
	private LocalDate date;
	
	
	
	public Transaction(TransactionType type, Category category, double amount, LocalDate date) {
		super();
		this.type = type;
		this.category = category;
		this.amount = amount;
		this.date = date;
	}

	
	//Getters
	
	public TransactionType getType() {
		return type;
	}




	public Category getCategory() {
		return category;
	}


	public double getAmount() {
		return amount;
	}


	public LocalDate getDate() {
		return date;
	}



	@Override
	public String toString() {
		return "Type=" + type + " ||  category=" + category + "  ||  amount=" + amount + "  ||  date=" + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
	public static Transaction fromString(String line) {
	    try {
	        String[] parts = line.split("\\|\\|");

	        String typePart = parts[0].split("=")[1].trim();
	        String categoryPart = parts[1].split("=")[1].trim();
	        String amountPart = parts[2].split("=")[1].trim();
	        String datePart = parts[3].split("=")[1].trim();

	        return new Transaction(
	            TransactionType.valueOf(typePart),
	            Category.valueOf(categoryPart),
	            Double.parseDouble(amountPart),
	            LocalDate.parse(datePart, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
	        );
	    } catch (Exception e) {
	        throw new IllegalArgumentException("Invalid line format: " + line);
	    }
	}

	
	

}
