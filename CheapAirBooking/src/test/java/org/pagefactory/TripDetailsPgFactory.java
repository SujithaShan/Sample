package org.pagefactory;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripDetailsPgFactory extends BaseClass {

	public TripDetailsPgFactory() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//b[@class='FlightSegment_Full__HourMinuesStyled-sc-18y1gd-3 iZePuD'])[1]")
	public WebElement depArrival;
	
	@FindBy(xpath="(//b[@class='FlightSegment_Full__HourMinuesStyled-sc-18y1gd-3 iZePuD'])[2]")
	public WebElement depDrop;
	
	@FindBy(xpath = "(//b[@class='FlightSegment_Full__HourMinuesStyled-sc-18y1gd-3 iZePuD'])[3]")
	public WebElement retArrival;
	
	@FindBy(xpath="(//b[@class='FlightSegment_Full__HourMinuesStyled-sc-18y1gd-3 iZePuD'])[4]")
	public WebElement retDrop;
	
	@FindBy(xpath="//button[@class='sc-hBxehG hygRrf']")
	public WebElement contnu;

}
