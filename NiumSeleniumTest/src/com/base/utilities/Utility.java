package com.base.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility {
	
	
	public static ArrayList<Item> get_top_N_items(List<WebElement> item_List, int number) throws InterruptedException {		
		if(number<=0 || item_List==null) {
			return null;
		}
		
		if(number>item_List.size()) {
			number =item_List.size()-1;
		}
		
		ArrayList<Item> items_list = new ArrayList<Item>();
		for(int i=2;i<=number+1;i++) {
			String item_tile =item_List.get(i).getText().trim();
			WebElement priceElement =item_List.get(i).findElement(By.xpath("parent::a/following-sibling::div[contains(@class,'s-item__details')]//span[@class='s-item__price']"));
			String price = priceElement.getText();
			System.out.println(price);
			Double item_price=0.0;
			if(!price.isEmpty()){
				 item_price =Double.parseDouble(price.trim().replace("$", ""));
			}
		
			//adding item title and price as new item object to the list of objects
			items_list.add(new Item(item_tile,item_price));		
		}
		
		//sort the list in the descending order of price
		Collections.sort(items_list,Collections.reverseOrder()); 
		return items_list;			
	}	

}
