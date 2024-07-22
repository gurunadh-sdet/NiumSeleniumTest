package com.base.utilities;


public class Item implements Comparable<Item> {
	String item_title;
	Double item_price;
	
	public Double getItem_price() {
		return item_price;
	}

	public void setItem_price(Double item_price) {
		this.item_price = item_price;
	}

	public String getItem_title() {
		return item_title;
	}

	public void setItem_title(String item_title) {
		this.item_title = item_title;
	}

	public Item(String item_title, Double item_price) {
		this.item_title=item_title;
		this.item_price=item_price;		
	}
	
	@Override
	public int compareTo(Item o) {
		if (getItem_price() == null || o.getItem_price() == null) {
		      return 0;
		    }
		    return getItem_price().compareTo(o.getItem_price());
	
	}
}
	

