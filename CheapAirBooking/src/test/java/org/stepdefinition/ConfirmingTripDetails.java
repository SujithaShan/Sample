package org.stepdefinition;

import java.io.IOException;

import org.baseclass.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pagefactory.TripDetailsPgFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ConfirmingTripDetails extends TripDetailsPgFactory {

	@Given("Verifying trip timings")
	public void verifying_trip_timings() {

		// TripDetailsPgFactory tp = new TripDetailsPgFactory();
		//
		// String depArrival = BaseClass.getText(tp.depArrival);
		// String depDrop = BaseClass.getText(tp.depDrop);
		// String retArrival = BaseClass.getText(tp.retArrival);
		// String retDrop = BaseClass.getText(tp.retDrop);
		//
		// if ((FlightDepature.flightDepPickTime.contains(depArrival))
		// && (FlightDepature.flightDepDropTime.contains(depDrop))) {
		// System.out.println("Depature equals");
		// }else {
		// System.out.println("not matching");
		// }
		//
		// if ((FlightReturn.flightRetPickTime.contains(retArrival))
		// && (FlightReturn.flightRetDropTime.contains(retDrop))) {
		// System.out.println("Return equals");
		// }

	}

	@When("Verifying passenger details")
	public void verifying_passenger_details() throws InterruptedException, IOException {
		TripDetailsPgFactory tp = new TripDetailsPgFactory();

		Thread.sleep(3000);

		String depArrival = BaseClass.getText(tp.depArrival);
		String depDrop = BaseClass.getText(tp.depDrop);
		String retArrival = BaseClass.getText(tp.retArrival);
		String retDrop = BaseClass.getText(tp.retDrop);

		BaseClass.screenShot("cheapair\\FlightTime");
		System.out.println(depArrival);
		System.out.println(depDrop);
		System.out.println(retArrival);
		System.out.println(retDrop);

		if (FlightDepature.flightDepPickTime.equals(depArrival)) {
			System.out.println("Depature equals");
		}

		if (FlightDepature.flightDepDropTime.equals(depDrop)) {
			System.out.println("Depature equals");
		}
		if (FlightReturn.flightRetPickTime.equals(retArrival)) {
			System.out.println("Depature equals");
		}
		if (FlightReturn.flightRetDropTime.equals(retDrop)) {
			System.out.println("Depature equals");
		}

		// checking passenger count
		int count = 0, scount = 0, child = 0, infant = 0;

		for (int i = 2; i <= 9; i++) {
			WebElement a = driver.findElement(By.xpath("(//table//tr)[" + i + "]//td[1]"));
			String text = BaseClass.getText(a);
			if (text.contains("Adult")) {
				count++;
			} else if (text.contains("Senior")) {
				scount++;
			} else if (text.contains("Child")) {
				child++;
			} else if (text.contains("Infant")) {
				infant++;
			}
		}

		if ((count == 5) && (scount == 1) && (child == 1) && (infant == 1)) {
			System.out.println("Passenger details are matching");
		}
		
		

	}

	@Then("Confirming trip")
	public void confirming_trip() throws IOException, InterruptedException {

		Thread.sleep(2000);
		TripDetailsPgFactory tp = new TripDetailsPgFactory();
		BaseClass.screenShot("cheapair\\PassengerVerify");
		tp.contnu.click();
	}
}
