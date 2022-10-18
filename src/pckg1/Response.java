package pckg1;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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

public class Response {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "C:\\Users\\rajesh.r\\Desktop\\TestData\\";
	public static final String File_TestData = "1covcategoryurl_22.xlsx";
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajesh.r\\Desktop\\chrome\\chromedriver.exe\\");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		 //  Reporter.initialize();
		// TODO Auto-generated method stub
		   
			   //HtmlUnitDriver driver = new HtmlUnitDriver();
					driver.manage().window().maximize();
					WebDriverWait wait = new WebDriverWait(driver, 20);
					for (int i=2027;i<=3349;i++)
					{
					
					driver.get("https://search.google.com/test/amp");
					
						
				Thread.sleep(3000);
				setExcelFile(Path_TestData + File_TestData, "Input");
			
				
				//System.out.println(url1);
				try {
					
				URL url = new URL(getCellData(i, 0));
				System.out.println("url is "+ url);
				System.out.println(i  +  getCellData(i, 0) );
				//loginfo("url is "+ url);
				//Reporter.Reportlog("Done","url is "+ url );
			//	
			//	JOptionPane.showConfirmDialog(null, null);
				HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				//JOptionPane.showConfirmDialog(null, null);	
				int code = connection.getResponseCode();
				System.out.println("code  is  " +  code);
				//loginfo("code  is  " +  code);
				
			//	
				setExcelFile(Path_TestData + File_TestData, "Input");
				//setCellData(code, i, 1);
				
				//JOptionPane.showMessageDialog(null, code);
				if(code==200)
				{
					  setExcelFile(Path_TestData + File_TestData, "Input");
						setCellData(connection.getResponseCode(), i, 1);
					
//					   setExcelFile(Path_TestData + File_TestData, "Input");
//						setCellData("Pass", i, 1);
					
				}
				else
				{
					setExcelFile(Path_TestData + File_TestData, "Input");
					setCellData(code, i, 1);
				}
				}catch(Exception e) {
//					
					continue;	
					}
					}
					}
			//
			


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

	public static void setCellData(double Result, int RowNum, int ColNum) throws Exception {

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




