package pckg1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CanonicalCov {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "C:\\Users\\rajesh.r\\Desktop\\TestData\\";
	public static final String File_TestData = "1LiveCanonocal.xlsx";
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void main(String[] args) throws Throwable {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajesh.r\\Desktop\\chrome\\chromedriver.exe\\");
		// Headless 
		  ChromeOptions options = new ChromeOptions();
	     options.addArguments(new String[] { "--test-type" });
	      options.setHeadless(true); 
	     WebDriver driver = new ChromeDriver(options);
		  // WebDriver driver = new ChromeDriver();
		  // driver.manage().window().maximize();
		   WebDriverWait wait = new WebDriverWait(driver, 15);
		   for(int i=654;i<=991;i++)
			{
				try {
				setExcelFile(Path_TestData + File_TestData,"Input");
				String getexcelurl = getCellData(i,0);
				driver.get(getexcelurl);
				System.out.println( i +"getexcelurl "+getexcelurl);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//link[@rel='canonical']")));
				String getconhref = driver.findElement(By.xpath("//link[@rel='canonical']")).getAttribute("href");
				System.out.println("getconhref "+getconhref);
				String expgetconhref = getCellData(i,1);
				System.out.println( i +" expgetconhref "+expgetconhref);
				
				
				if(getconhref.trim().equalsIgnoreCase(expgetconhref.trim()))
				{
					setCellData(getconhref, i, 2);
					setCellData("Pass", i, 3);
				}
				else
				{
					setCellData(getconhref, i, 2);
					setCellData("Fail", i, 3);
				}
				}
				catch(Exception e)
				{
					setCellData("No canonical Tag present 404 page ", i, 2);
					setCellData("Fail", i, 3);
				}
			}
		   }

public static void clickjavascriptelement(WebDriver driver, WebElement element){

	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);

	}

public static void waitForLoaderToDisMiss(WebDriver driver) {
	try {
	new WebDriverWait(driver, 50).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='loading-mask' or @class='loader']"))));
	}catch (Exception e) {
		System.out.println("Big Loader does not exist");
	} 
}
public void waitForPageLoad(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")); 
}
public static void waitForLoaderToDisMiss2(WebDriver driver) {
	try {
		new WebDriverWait(driver, 50).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='fotorama__spinner fotorama__spinner--show']"))));
		}catch (Exception e) {
			System.out.println(" side Loader does not exist");
		}
	}

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

		try {
			
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);

		//	Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}
			
			

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Path_TestData + File_TestData);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			throw (e);

		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}

	}

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}
	
	public static WebElement getdropdownselect(WebDriver driver)
	{
		
	    WebElement dropsecond = driver.findElement(By.xpath("(//select[@name!=''])[2]"));
	    String getdropdwnatt = dropsecond.getAttribute("name");
	    
	    if(getdropdwnatt.trim().equalsIgnoreCase("size_unit"))
	    {
	    	WebElement drp = driver.findElement(By.xpath("(//select[@name!=''])[3]"));
	    	return drp;
	    }
	    else
		{
			return dropsecond;
		}
	}
	
	public static String getdropdownnextselect(WebDriver driver)
	{
		
	    WebElement dropsecond = driver.findElement(By.xpath("(//select[@name!=''])[2]"));
	    String getdropdwnatt = dropsecond.getAttribute("name");
	    
	    if(getdropdwnatt.trim().equalsIgnoreCase("size_unit"))
	    {
	    	WebElement drp = driver.findElement(By.xpath("(//select[@name!=''])[3]"));
	    	return "(//select[@name!=''])[3]";
	    }
	    else
		{
			return "(//select[@name!=''])[2]";
		}
	}
	
	}




