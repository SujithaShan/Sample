package org.pagefactory;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassengerDetailsPgFactory extends BaseClass {

	
	public PassengerDetailsPgFactory() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ccNum1")
	public WebElement ccNum;
	
	@FindBy(id="expMonth1")
	public WebElement ccMonth;
	
	@FindBy(id="expYear1")
	public WebElement ccYear;
	
	@FindBy(id="cvv1")
	public WebElement cvv;
	
	@FindBy(id="paymentCountry1")
	public WebElement country;
	
	@FindBy(id="paymentName1")
	public WebElement ccName;
	
	@FindBy(id="paymentAddress1")
	public WebElement payAddrs;
	
	@FindBy(id="paymentAddress21")
	public WebElement payAddrs2;
	
	@FindBy(id="paymanetCity1")
	public WebElement payCity;
	
	@FindBy(id="paymentZip1")
	public WebElement payZip;
	
	@FindBy(id="paymentPhone1")
	public WebElement phone;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="password")
	public WebElement pass;
	
	@FindBy(id="confirmPassword")
	public WebElement cPass;
	
	
	
	
}
