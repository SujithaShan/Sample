package org.pagefactory;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePgFactory extends BaseClass{

	public HomePgFactory() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label//span[1]")
	public WebElement trip;
	
	@FindBy(id="from1")
	public WebElement from;
	
	@FindBy(id="to1")
	public WebElement to;
	
	@FindBy(id="departs")
	public WebElement departDate;
	
	@FindBy(id="returns")
	public WebElement returnDate;
	
	@FindBy(id="options")
	public WebElement passgr;
	
	@FindBy(xpath="//input[@id='adults']/following-sibling::button[2]")
	public WebElement adults;
	
	@FindBy(xpath="//input[@id='seniors']/following-sibling::button[2]")
	public WebElement senoirs;
	
	@FindBy(xpath="//input[@id='children']/following-sibling::button[2]")
	public WebElement children;
	
	@FindBy(xpath="//input[@id='infants']/following-sibling::button[2]")
	public WebElement infant;
	
	@FindBy(id="cabin")
	public WebElement cabin;
	public String cabinVal = "Y"; 
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	public WebElement search;
	
	
	
	
	
	
}
