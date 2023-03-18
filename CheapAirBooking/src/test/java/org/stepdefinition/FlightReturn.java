package org.stepdefinition;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pagefactory.DepaturePgFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightReturn {

	public static String flightRetPickTime;
	public static String flightRetDropTime;
	WebElement findElement;

	@When("Confirming return timing")
	public void confirming_return_timing() throws InterruptedException, IOException {
		BaseClass.iWait(30);
		DepaturePgFactory dP = new DepaturePgFactory();
		Thread.sleep(3000);
		// System.out.println(BaseClass.getText(dP.ret));
		FlightDepature fd = new FlightDepature();
		fd.sortTime();
		flightRetPickTime = fd.PickTime;
		flightRetDropTime = fd.DropTime;
		BaseClass.screenShot("cheapair\\Return");
	}

	@Then("Choosing return flight")
	public void choosing_return_flight() {
		DepaturePgFactory dP = new DepaturePgFactory();
		FlightDepature fd = new FlightDepature();
		fd.sortTime();
		BaseClass.iWait(10);
		WebDriver driver = BaseClass.driver;

		findElement = driver
				.findElement(By.xpath("(//span[@class=\"sc-heFykY dnRYbf\"])[" + FlightDepature.firstKey + "]"));

		BaseClass.acClick(findElement);
	}

}
