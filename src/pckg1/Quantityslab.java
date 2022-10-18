package pckg1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import bBScripts_withHtmlReport.Reporter;

//import bBScripts_withHtmlReport.Reporter;

//import Glib.Glib;
//import bBScripts_withHtmlReport.Reporter;

public class Quantityslab {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "F:\\COMERCPUNDIT19\\Cp2020\\src\\testData\\";
	public static final String File_TestData = "1quntity.xlsx";
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	

	public static void main(String[] args) throws Exception {
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\Chromdrivr\\chromedriver.exe\\");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   WebDriverWait wait = new WebDriverWait(driver, 20);
		   for(int i=15;i<=200;i++)
			{
//				try {
				setExcelFile(Path_TestData + File_TestData,"Input");
				String getexcelurl = getCellData(i,0);
				driver.get(getexcelurl);
				System.out.println( i +"getexcelurl "+getexcelurl);
				//JOptionPane.showConfirmDialog(null, "1");
			//	Thread.sleep(10000);
				for(int k=1;k<=20;k++)
				{
					Thread.sleep(1000);
					try
					{
						driver.findElement(By.xpath("//*[text()='Bulk Quantity Discount']"));
					}
					catch(Exception e)
					{
						
					}
				}
							
				
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Bulk Quantity Discount']")));
				try
				{
				
					driver.findElement(By.xpath("//*[text()='Bulk Quantity Discount']"));
					//JOptionPane.showConfirmDialog(null, "3");
				List<WebElement> qtyslab = driver.findElements(By.xpath("//*[@class='quantityColumnTwo']")); 	
			
				for(int v=1;v<qtyslab.size();v++)
				{
					
					if(qtyslab.get(v).getText().trim().contains("%"))
					{
						System.out.println("Fail "+qtyslab.get(v).getText().trim());
						setCellData("Fail", i, 1);
					//	setCellData(qtyslab.get(v).getText().trim(),1+v,1);
						
					}
					else if(qtyslab.get(v).getText().trim().contains("$"))
						//£,$
	
					{
						setCellData("pass", i, 1);
						System.out.println("Pass "+qtyslab.get(v).getText().trim());
						//setCellData(qtyslab.get(v).getText().trim(),1+v,1);
					}
					else
					{
						System.out.println("Fail no value "+qtyslab.get(v).getText().trim());
						//setCellData(qtyslab.get(v).getText().trim(),1+v,1);
					}
				}
				}
				catch (Exception e)
				{
					//JOptionPane.showConfirmDialog(null, "fail");
					System.out.println("Fail bcaz "+e);
					setCellData("Fail as no Quantity slap table on pdp", i, 1);
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
	}




