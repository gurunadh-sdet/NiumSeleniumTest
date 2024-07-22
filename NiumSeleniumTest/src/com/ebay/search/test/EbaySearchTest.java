package com.ebay.search.test;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.utilities.Item;
import com.base.utilities.Utility;

public class EbaySearchTest extends BaseTest {

	
	@Parameters({"keyword","counter"})
	@Test
	public List<Item> eBaySearchMethod(String keyword, int counter) throws IOException, InterruptedException{		
	
		//1. Search for the given keyword
		driver.findElement(By.id("gh-ac")).clear();	//clearing the search keyword so that it can be called multiple times
		driver.findElement(By.id("gh-ac")).sendKeys(keyword);	
		driver.findElement(By.id("gh-btn")).click();
		
		//2. Get the list of item titles
		List<WebElement> item_title = driver.findElements(By.xpath("//div[contains(@class,'s-item__wrapper')]//div[@class='s-item__title']"));
		
		//3. Call the utility method to get the descending order of item title and price
		List<Item> items_list =Utility.get_top_N_items(item_title,counter);
		return items_list;
	}
	
	@Test	// this is to test the positive case
	public void SearchMethod_Test1() throws IOException, InterruptedException {
		Assert.assertEquals(eBaySearchMethod("iphone", 4).size(),4);
	}
	
	@Test	// when the search result is empty
	public void SearchMethod_Test2() throws IOException, InterruptedException {
		Assert.assertEquals(eBaySearchMethod("dfvhmbjjewfjk", 3), List.of());
	}
	
	@Test	//when the given number was negative
	public void SearchMethod_Test3() throws IOException, InterruptedException {
		Assert.assertEquals(eBaySearchMethod("shoe", -2), null);
	}
	
	@Test	//when the give number is greater than number of matches for the keyword=> here I am returning whatever found
	public void SearchMethod_Test4() throws IOException, InterruptedException {
		Assert.assertTrue(!eBaySearchMethod("gurunadh", 10).isEmpty());
		List<Item> items_list = eBaySearchMethod("gurunadh", 10);
		if(items_list!=null) {
			for(Item i:items_list)
			System.out.println(i.getItem_title()+"----$"+i.getItem_price());
		}
	}
	
}
