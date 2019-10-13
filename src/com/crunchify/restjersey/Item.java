package com.crunchify.restjersey;

public class Item {
	
	private String name;
	private int amount;
	
	public Item(String name) {
		this.name = name;
		this.amount = 0;
	}
	
	public Item(String name, int amount) {
		this.name = name;
		this.amount = amount;	
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void incrementAmount(int amount) {
		this.amount = this.amount + amount;
	}
	
	public void removeAmount(int amount) {
		
		
		int tempamount = this.amount - amount;
		
		if(tempamount >= 0) {
			this.amount = tempamount;
		}
		
		
	}
	
	
	
	
	
	
	

}
