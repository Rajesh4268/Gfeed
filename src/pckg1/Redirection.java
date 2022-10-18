package pckg1;


import java.io.FileInputStream;
import java.io.FileOutputStream;

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

public class Redirection {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "C:\\Users\\rajesh.r\\Desktop\\TestData\\";
	public static final String File_TestData = "GMRedirectionUrls_22.xlsx";
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
		   for(int i=1;i<=30;i++)
			{
				//try {
			//	long time=System.currentTimeMillis();
				
				setExcelFile(Path_TestData + File_TestData,"Input");
			String	getexcelurl = getCellData(i,0);
			//	try {
				System.out.println("getexcelurl "+getexcelurl);
				driver.get(getexcelurl.trim());
				System.out.println( i   +  "getexcelurl "+ getexcelurl);
				//Reporter.Reportlog("Done", "Launching Url is "+getexcelurl);
				Thread.sleep(10000);
				String redirectURL = driver.getCurrentUrl();
				System.out.println("Redirect uel is " + redirectURL );
//				 setExcelFile(Path_TestData + File_TestData, "Sheet1");
					setCellData(redirectURL, i, 1);
				if(!getexcelurl.trim().equalsIgnoreCase(redirectURL.trim())) 
				{
					System.out.println("Pass");
					setCellData("PassUrl", i, 3);
				}	
				else {
					System.out.println("Fail");
					setCellData("FailUl", i, 3);
				}	
					
//---BannerBuzz				
		//		String getsource = driver.getPageSource();
					    
		        	
					
//				if(getexcelurl.trim().equalsIgnoreCase(redirectURL.trim()))
//				{
//					if(redirectURL.contains("/p")) {
//						System.out.println("Fail");
//						setCellData("Fail", i, 3);
//					//	Reporter.Reportlog("fail", "wrong Redirection" +  getCellData(i,0) );
//					}
//					if(getsource.contains("PageNotFound")|| getsource.contains("Page Not Found"))
//					{
//					System.out.println("Fail");
//					setCellData("Fail", i, 2);
//					//Reporter.Reportlog("fail", "wrong Redirection" +  getCellData(i,0) );
//					}
//					else
//					{
//						System.out.println("Pass");
//						setCellData("Pass", i, 2);
//					//	Reporter.Reportlog("Pass", " Valid Redirection " +  getCellData(i,0) );
//					}
//				}
//				else
//				{
//					System.out.println("FailURL");
//					setCellData("FailURL", i, 2);
//				//	Reporter.Reportlog("fail", "wrong Redirection" +  getCellData(i,0) );
//					}
			//	 System.out.println("TIme taken in secs: "+(System.currentTimeMillis()-time)/1000);		
				//System.out.println("Time Taken in Seconds:"+ (System.currentTimeMillis()-time/1000 ));
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




