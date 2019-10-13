
package com.crunchify.restjersey;
 
/**
 * @author Crunchify.com
 * * Description: This program converts unit from Centigrade to Fahrenheit.
 * Last updated: 12/28/2018
 */
 
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.*;
 
@Path("/lab2")
public class Lab2 {
	
	ArrayList<Item> stock;
	
	public Lab2() {
		stock = new ArrayList<Item>();
		Item item = new Item("cheese", 5);
		stock.add(item);
		Item item1 = new Item("cabbage", 5);
		stock.add(item1);
		Item item2 = new Item("cucumber", 5);
		stock.add(item2);
	}
	
	@Path("/additem/{c}")
	@POST
	@Produces("application/xml")
	public String addItem(@PathParam("c") String c) {
				
		for(Item x : stock) {
			if(x.getName().equals(c)) {
				return c + " already exists in stock";
			}
		}
		
		Item item = new Item(c, 0);
		
		stock.add(item);
		
		return c + " added to stock";
					
	}
	
	@Path("/setstock/{c}/{d}")
	@PUT
	@Produces("application/xml")
	public String setStock(@PathParam("c") String c, @PathParam("d") int d) {
		
		String result;
		
		for(Item x : stock) {
			if(x.getName().equals(c)) {
				x.setAmount(d);
				
				return d + " items of " + c + " added to stock";
			}
		}
		
		result = "Item  does not exist in stock management system";
		return result;		

	}
	
	@Path("/addstock/{c}/{d}")
	@PUT
	@Produces("application/xml")
	public String addStock(@PathParam("c") String c, @PathParam("d") int d ) {
		
		String result;
		
		for(Item x : stock) {
			if(x.getName().equals(c)) {
				x.incrementAmount(d);
				result = c + " stock has been incremented by " + d + " to " + x.getAmount();
				return result;
			}
		}
		
		result = "Item  does not exist in stock management system";
		
		return result;
		
	}
	
	@Path("/removestock/{c}/{d}")
	@DELETE
	@Produces("application/xml")
	public String removeStock(@PathParam("c") String c,@PathParam("d") int d ) {
		
		String name = null;
		int amount = 0;
		
		if(stock.size() == 0) {
			return "@Produces(\"application/xml\") Output: No items in stock";
		}
		else {
			
			for(Item x : stock) {
				if(x.getName().equals(c)){
					if(d <= x.getAmount()) {
						x.removeAmount(d);
						name = x.getName();
						amount = x.getAmount();
						return "Item: " + name + " Amount: " + amount;	
					}
					else {
						return "Amount greater than stock amount";
					}
				}
			}
			
		}
		
		return "Item  does not exist in stock management system";
	}
	
	
	@Path("/liststock")
	@GET
	@Produces("application/xml")
	public String listStock() {
		
		String result ="";
		String name;
		int amount;
		
		if(stock.size() == 0)
		{
			result = "No Stock items";
			name = "";
			amount = 0;
		}
		else {
			
			for(Item x : stock)
			{		
				name = x.getName();
				amount = x.getAmount();
				
				result = result + "Item: " + name + " Stock: " + amount + "\n";
			}			
		}
		
		
		return result;
	}
	

}







