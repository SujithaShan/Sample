package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
/* import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; */
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Select select;
	public static List<WebElement> list;
	public static JavascriptExecutor js;
	public static WebElement element;
	public static Actions actions;
	public static Robot robot;
	public static String excelPath;

	public static File file;
	public static FileInputStream fis;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest testLog;

	// Launch SetUp

	public static void browser(String browser) {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}
	}

	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void iWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public static void eWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	public static void getCurrentURL() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	// locators

	public static List<WebElement> listOfElement(By element) {
		List<WebElement> list = driver.findElements(element);
		System.out.println(list.size());
		return list;
	}
	
	
	
	// Get Text and Attribute

	public static String getText(WebElement element) {

		
		String s = element.getText();
		return s;

	}

	public static String getAttri(WebElement element) {

		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		return attribute;

	}

	// Submit Click Clear SendKeys

	public static void submit(WebElement a) {
		a.submit();
	}

	public static void clear(WebElement a) {
		a.clear();
	}

	public static void click(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();

	}

	public static void inputValue(WebElement element, String value) {
		element.click();
		element.sendKeys(value);
	}

	// Actions

	public static void moveTo(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public static void acClick(WebElement element) {
		actions = new Actions(driver);
		actions.click(element).build().perform();
	}

	public static void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public static void doubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public static void dragDrop(WebElement src, WebElement des) {
		actions = new Actions(driver);
		actions.dragAndDrop(src, des).build().perform();
	}

	// Robot class

	public static void selectDownforText() throws AWTException {
		robot = new Robot();
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void robEnter() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void selectDownkey(int n) throws AWTException {
		// element.click();
		robot = new Robot();

		for (int i = 1; i <= n; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
		}

		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	// Select DropDown

	public static void selectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	// JavaScriptExecutor
	// Scroll
	public static void scrollToView(WebElement element) {
		// element = driver.findElement(a);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	public static void scroll(int x, int y) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");

	}

	// passing value
	public static Object jsInputValue(WebElement element, String value) {
		js = (JavascriptExecutor) driver;
		Object aObject = js.executeScript("arguments[0].value='" + value + "'", element);
		return aObject;
	}

	// printing value
	public static Object jsReturnValue(WebElement element) {
		Object print = js.executeScript("return arguments[0].getAttribute('value')", element);
		return print;
	}

	// click element
	public static void jsClick(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}

	// frames

	public static void switchFrame(int index) {
		driver.switchTo().frame(index);
	}

	public static void switchFrame(String value) {
		driver.switchTo().frame(value);
	}

	public static void switchFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public static void defaultPage() {
		driver.switchTo().defaultContent();
	}

	// Alert

	public static Alert alert() {
		Alert alrt = driver.switchTo().alert();
		return alrt;

	}

	// Windows

	public static void switchWindow(int index) {
		String parent = driver.getWindowHandle();

		Set<String> children = driver.getWindowHandles();
		List<String> change = new ArrayList<>(children);
		driver.switchTo().window(change.get(index));
	}

	// Radio CheckBox selected disabled enabled

	public static void buttonStatus(String check, WebElement element) {

		switch (check) {
		case "isSelected":
			System.out.println(element.isSelected());
			break;
		case "isEnabled":
			System.out.println(element.isEnabled());
			break;
		case "isDisabled":
			System.out.println(element.isDisplayed());
			break;
		}

	}

	public static void radio(WebElement radio) {
		// WebElement radio = driver.findElement(By.xpath(gender));
		if (!radio.isSelected()) {
			radio.click();
		}
	}

	public static void checkBox(WebElement element) {
		WebElement check = element;
		// if (!check.isSelected()) {
		check.click();
		// }
	}

	// ScreenShot
	public static void screenShot(String desc) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\Users\\Dell\\Desktop\\Testing Course\\Task\\" + desc + ".jpeg";

		File save = new File(destination);

		FileUtils.copyFile(source, save);
	}

	//

	public static String mappingResult(String key, String value) {

		Map<String, String> m = new LinkedHashMap<>();
		m.put(key, value);

		String result = m.toString();
		System.out.println(result);
		return result;

	}

	// Close and Quit

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	
/*	   public static String readExcel(int i, int j) throws IOException { File file =
	   new File(excelPath); FileInputStream fis = new FileInputStream(file);
	   
	   Workbook wb = new XSSFWorkbook(fis); Sheet sheet = wb.getSheet("Sheet1"); Row
	   row = sheet.getRow(i); Cell cell = row.getCell(j);
	   
	   CellType cType = cell.getCellType();
	   
	   String str = null; if (cType == CellType.STRING) { str =
	   cell.getStringCellValue();
	   
	   } else if (cType == CellType.NUMERIC) { if
	   (DateUtil.isCellDateFormatted(cell)) { Date dateCellValue =
	   cell.getDateCellValue(); SimpleDateFormat sd = new
	   SimpleDateFormat("dd MMM yyyy"); str = sd.format(dateCellValue); } else {
	   double numericCellValue = cell.getNumericCellValue(); long num = (long)
	   numericCellValue; str = String.valueOf(num); } }
	   
	   return str;
	   
	   }
	   
	   public static String readAllData() throws IOException { File file = new
	   File(excelPath); FileInputStream fis = new FileInputStream(file);
	   
	   Workbook wb = new XSSFWorkbook(fis); Sheet sheet = wb.getSheet("Sheet1");
	   String str = null;
	   
	   for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { Row row =
	   sheet.getRow(i); for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
	   Cell cell = row.getCell(j); CellType cType = cell.getCellType(); if (cType ==
	   CellType.STRING) { str = cell.getStringCellValue();
	   
	   } else if (cType == CellType.NUMERIC) { if
	   (DateUtil.isCellDateFormatted(cell)) { Date dateCellValue =
	   cell.getDateCellValue(); SimpleDateFormat sd = new
	   SimpleDateFormat("dd-MMM-YYYY"); str = sd.format(dateCellValue); } else {
	   double numericCellValue = cell.getNumericCellValue(); long num = (long)
	   numericCellValue; str = String.valueOf(num); } } } } return str; }
	   
	   public static String[][] excelData() throws IOException {
	   
	   File file = new File(excelPath); FileInputStream fis = new
	   FileInputStream(file); Workbook wk = new XSSFWorkbook(fis); Sheet sheet =
	   wk.getSheet("Sheet1");
	   
	   Row row = sheet.getRow(0); int rowsSize = sheet.getPhysicalNumberOfRows() -
	   1; int lastCell = row.getPhysicalNumberOfCells();
	   
	   String[][] data = new String[rowsSize][lastCell];
	   
	   for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
	   
	   for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) { Cell text =
	   sheet.getRow(i).getCell(j); data[i - 1][j] = text.getStringCellValue(); } }
	   return data; }
	   
	   public static void writeData(int i, int j, String str) throws IOException {
	   File file = new File(
	   "C:\\Users\\Dell\\eclipse-workspace\\AdactinHotelApp\\Resources\\Book1.xlsx")
	   ; FileInputStream fis = new FileInputStream(file); Workbook wb = new
	   XSSFWorkbook(fis);
	   
	   Sheet sheet = wb.getSheet("Sheet1"); Row row = sheet.getRow(i); Cell cell =
	   row.createCell(j);
	   
	   cell.setCellValue(str); FileOutputStream fos = new FileOutputStream(file);
	   wb.write(fos); fos.close();
	   
	   }*/
	 

	public static String readProp(String key) throws IOException {
		String path = "C:\\Users\\Dell\\eclipse-workspace\\CheapAirBooking\\src\\test\\resources\\config.properties";

		file = new File(path);
		fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

	public static void extentReport(String test) {
		htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		testLog = extent.createTest(test);

	}

}
