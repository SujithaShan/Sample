package org.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.pagefactory.HomePgFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class HomeStepDefinition extends HomePgFactory {

	@Given("Choosing trip")
	public void choosing_trip() {
		BaseClass.iWait(30);
		HomePgFactory hp = new HomePgFactory();
		hp.trip.click();

	}

	@When("Choosing Places and Dates")
	public void choosing_places_and_dates() throws AWTException, IOException {
		BaseClass.iWait(30);
		HomePgFactory hp = new HomePgFactory();
		BaseClass.inputValue(hp.from, BaseClass.readProp("from"));
		BaseClass.selectDownforText();

		BaseClass.inputValue(hp.to, BaseClass.readProp("to"));
		BaseClass.selectDownforText();
		BaseClass.inputValue(hp.departDate, BaseClass.readProp("departure"));
		BaseClass.inputValue(hp.returnDate, BaseClass.readProp("return"));
		BaseClass.click(hp.to);
	}

	@When("Enter list of passengers")
	public void enter_list_of_passengers() throws NumberFormatException, IOException {
		HomePgFactory hp = new HomePgFactory();
		BaseClass.click(hp.passgr);

		int adult = Integer.parseInt(BaseClass.readProp("adult"));

		for (int i = 1; i < adult; i++) {
			BaseClass.click(hp.adults);
		}

		int senior = Integer.parseInt(BaseClass.readProp("senior"));

		for (int i = 0; i < senior; i++) {
			BaseClass.click(hp.senoirs);
		}

		int children = Integer.parseInt(BaseClass.readProp("children"));

		for (int i = 0; i < children; i++) {
			BaseClass.click(hp.children);
		}

		int infant = Integer.parseInt(BaseClass.readProp("infant"));

		for (int i = 0; i < infant; i++) {
			BaseClass.click(hp.infant);
		}
		BaseClass.screenShot("cheapair\\HomePg");
	}

	@Then("validate the Information")
	public void validate_the_information() throws IOException {
		HomePgFactory hp = new HomePgFactory();
		// String FromExpected = BaseClass.readProp("from");
		Assert.assertNotNull(BaseClass.getAttri(hp.from));
		Assert.assertNotNull(BaseClass.getAttri(hp.to));
		Assert.assertNotNull(BaseClass.getAttri(hp.departDate));
		Assert.assertNotNull(BaseClass.getAttri(hp.returnDate));

		BaseClass.selectByValue(hp.cabin, hp.cabinVal);
		
		
		try {
			BaseClass.iWait(30);
			BaseClass.click(hp.search);
			BaseClass.switchWindow(1);
		} catch (Exception e) {
			BaseClass.click(hp.from);
			BaseClass.click(hp.to);
			BaseClass.click(hp.search);
			BaseClass.switchWindow(1);
		}
		// BaseClass.switchWindow(1);
		

	}
}
