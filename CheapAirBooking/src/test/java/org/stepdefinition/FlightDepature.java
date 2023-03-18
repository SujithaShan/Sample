package org.stepdefinition;

import java.io.IOException;
import java.sql.Time;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pagefactory.DepaturePgFactory;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class FlightDepature extends DepaturePgFactory {

	public static String flightDepPickTime;
	public static String flightDepDropTime;
	String PickTime;
	String DropTime;
	public static Integer firstKey;
	public static Integer firstValue;
	public WebElement findElement;
	
	
	
	public void sortTime() {
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='sc-heFykY dnRYbf']"));
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<list.size();i++) {
			String text = list.get(i).getText().replaceAll("[$,]*", "");
			int parseInt = Integer.parseInt(text);
			map.put(i+1,parseInt);
		}
		
		
		List list1 = new LinkedList(map.entrySet());  
		//Custom Comparator  
		Collections.sort(list1, new Comparator()   
		{  
		public int compare(Object o1, Object o2)   
		{  
		return ((Comparable) 
				((Map.Entry) (o1))
				.getValue())
				.compareTo(((Map.Entry) (o2)).getValue());  
		}  
		}); 
		System.out.println(list1);
		HashMap sortedHashMap = new LinkedHashMap();  
		for (Iterator it = list1.iterator(); it.hasNext();)   
		{  
		 Map.Entry entry = (Map.Entry) it.next();  
		sortedHashMap.put(entry.getKey(), entry.getValue());  
		}   
		
		Map.Entry<Object,Object> firstEntry = (Entry<Object, Object>) sortedHashMap.entrySet().iterator().next();
		firstKey = (Integer) firstEntry.getKey();
		firstValue = (Integer) firstEntry.getValue();

		//System.out.println("First key: " + firstKey);
		//System.out.println("First value: " + firstValue);
		 PickTime = driver.findElement(By.xpath("(//span[@class='sc-heFykY dnRYbf'])[1]/ancestor::div[contains(@class,'hzdsvF')]/preceding::span[@class='sc-fCYGkp jigVaQ'][2]")).getText();
		 DropTime = driver.findElement(By.xpath("(//span[@class='sc-heFykY dnRYbf'])[1]/ancestor::div[contains(@class,'hzdsvF')]/preceding::span[@class='sc-fCYGkp jigVaQ'][1]")).getText();
		//System.out.println(PickTime +"   "+DropTime);
	}
	
	@Given("Sorting flights by price")
	public void sorting_flights_by_price() {
		BaseClass.iWait(30);
		//BaseClass.getCurrentURL();
		DepaturePgFactory dP = new DepaturePgFactory();
		try {
			BaseClass.click(dP.dealClose);
		} catch (Exception e) {
			System.out.println("no deal");
		}
		
	}

	@When("Choosing lowest price flight")
	public void choosing_lowest_price_flight() throws IOException {

		DepaturePgFactory dP = new DepaturePgFactory();
		this.sortTime();
		flightDepPickTime = this.PickTime;
		flightDepDropTime = this.DropTime;
		BaseClass.screenShot("cheapair\\Depature");

	}

	@Then("Confiming flight timing")
	public void confiming_flight_timing() throws InterruptedException {
		DepaturePgFactory dP = new DepaturePgFactory();
		findElement = driver.findElement(By.xpath("(//span[@class=\"sc-heFykY dnRYbf\"])["+firstKey+"]"));
		BaseClass.acClick(findElement);
		Thread.sleep(3000);
	}

	
}
