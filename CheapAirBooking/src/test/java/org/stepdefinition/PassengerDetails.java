package org.stepdefinition;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.pagefactory.PassengerDetailsPgFactory;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PassengerDetails extends BaseClass {

	@When("Passenger Details")
	public void passenger_details(DataTable d) throws InterruptedException {
		
		Thread.sleep(2000);
		
		try {
			BaseClass.click(driver.findElement(By.xpath("(//span[@class='sc-bcXHqe bJOVkr'])[4]")));
		} catch (Exception e) {
			System.out.println("nothing");
		}
		
		try {
			BaseClass.click(driver.findElement(By.xpath("//span[@class='sc-bcXHqe bJOVkr']")));
		} catch (Exception e) {
			System.out.println("nothing");
		}
		for (int i = 1; i <= 8; i++) {
			
				driver.findElement(By.id("firstName" + i)).sendKeys(d.cell(0, i));
				driver.findElement(By.id("lastName"+i)).sendKeys(d.cell(1, i));
				BaseClass.selectByText(driver.findElement(By.id("gender"+i)), d.cell(2, i));
				BaseClass.selectByText(driver.findElement(By.id("dobMonth"+i)), d.cell(3, i));
				driver.findElement(By.id("dobDay"+i)).sendKeys(d.cell(4, i));
				driver.findElement(By.id("dobYear"+i)).sendKeys(d.cell(5, i));
				
				
			
		}
	}

	@Then("Enter Card Details")
	public void enter_card_details(DataTable data) {
		
		PassengerDetailsPgFactory p = new PassengerDetailsPgFactory();
		
		BaseClass.inputValue(p.ccNum, data.cell(0, 0));
		BaseClass.selectByValue(p.ccMonth, data.cell(1, 0));
		BaseClass.selectByValue(p.ccYear, data.cell(2, 0));
		
		BaseClass.inputValue(p.cvv, data.cell(3, 0));
		BaseClass.inputValue(p.ccName, data.cell(4, 0));
		
		BaseClass.selectByValue(p.country, data.cell(5, 0));
		BaseClass.inputValue(p.payAddrs, data.cell(6, 0));
		BaseClass.inputValue(p.payAddrs2, data.cell(7, 0));
		BaseClass.inputValue(p.payCity, data.cell(7, 0));
		BaseClass.inputValue(p.phone, data.cell(8, 0));
		BaseClass.inputValue(p.email, data.cell(9, 0));
		BaseClass.inputValue(p.pass, data.cell(10, 0));
		BaseClass.inputValue(p.cPass, data.cell(11, 0));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			}

}
