package org.pagefactory;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DepaturePgFactory extends BaseClass {

	public DepaturePgFactory() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='sc-fnGiBr kCVmbb']")
	public WebElement dealClose;

	@FindBy(xpath = "//div[text()='Madras, India to Delhi, India']")
	public WebElement location;

	@FindBys({ @FindBy(xpath = "//div[@aria-expanded='false']"), 
		@FindBy(xpath = " //div[@aria-controls='radix-0']") })
	public WebElement sort;

	@FindBy(xpath = "//div[contains(text(),'Price')]")
	public WebElement sortbyprice;

	@FindBy(xpath = "(//span[@class='sc-heFykY dnRYbf'])[1]")
	public WebElement chooseup;

	@FindBy(xpath = "(//span[@class='sc-fCYGkp jigVaQ'])[1]")
	public WebElement deppickTime;

	@FindBy(xpath = "(//span[@class='sc-fCYGkp jigVaQ'])[2]")
	public WebElement depdropTime;

	@FindBy(xpath = "(//div[@class='src__Box-sc-1sbtrzs-0 dyjEub'])[1]")
	public WebElement ret;

	@FindBy(xpath = "(//span[@class='sc-fCYGkp jigVaQ'])[1]")
	public WebElement returnPick;

	@FindBy(xpath = "(//span[@class='sc-fCYGkp jigVaQ'])[2]")
	public WebElement returnDrop;

	@FindBy(xpath = "(//span[@class='sc-heFykY dnRYbf'])[1]")
	public WebElement chooseReturn;
}
