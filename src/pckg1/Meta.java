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

//import Glib.Glib;
//import bBScripts_withHtmlReport.Reporter;

public class Meta {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "F:\\COMERCPUNDIT19\\Cp2020\\src\\testData\\";
	public static final String File_TestData = "1COVMetaTesting.xlsx";
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void main(String[] args) {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\Chromdrivr\\chromedriver.exe\\");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   for(int i=1;i<=1;i++)
			{
				try {
				setExcelFile(Path_TestData + File_TestData,"Input");
				String getexcelurl = getCellData(i,0);
				driver.get(getexcelurl);
				System.out.println( i +"getexcelurl "+getexcelurl);
				String pagetitle= driver.findElement(By.xpath("//*[@class='page-sub-title']")).getText();
				System.out.println("Page title is : " + pagetitle);
				setExcelFile(Path_TestData + File_TestData, "Input");
				setCellData(pagetitle, i, 11);
				//Reporter.Reportlog("Done", "Launching Url is "+getexcelurl);
				
		}catch(Exception e) {
					
				}
			//META DESCRIPT	
				try {
			String Actdescription = driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content");
			System.out.println(Actdescription);
			//Reporter.Reportlog("Done", "Reading metadata from Application");
			//String Actdescripti=getCellData(i, 2);
			setExcelFile(Path_TestData + File_TestData, "Input");
			setCellData(Actdescription, i, 4);
			
//			System.out.println("exp  "+Actdescription);
//			String getexpprice = getCellData(i, 4);
//			System.out.println("exp  "+getexpprice);
			
				
			
			//---
			
			String Extdata = getCellData(i,2);
			System.out.println("exp "+Extdata);

			System.out.println("act "+Actdescription);
			
			if(Actdescription.trim().equals(Extdata.trim()))
			{
				System.out.println("pass");
				setExcelFile(Path_TestData + File_TestData, "Input");
				setCellData("Pass", i, 5);
				//Reporter.Reportlog("Pass", "Description Url: "+getCellData(i,0));
			}
			else
			{
				System.out.println("fail");
				setExcelFile(Path_TestData + File_TestData, "Input");
				setCellData("Fail", i, 5);
			//	Reporter.Reportlog("Fail", "Description Url: "+getCellData(i,0) );
				
			}

			//---metatitle
				
		       String Actmetatitle = driver.getTitle(); 
	//	    		   driver.findElement(By.xpath("//*[@name='title']")).getAttribute("content");
		       System.out.println("abc1 "+Actmetatitle);
		    //   JOptionPane.showConfirmDialog(null, null);
		       ////*[@name='title']
		       ////meta[@property='twitter:title']
		     //  Reporter.Reportlog("Done", "Reading metaTitle from Application");
		       setExcelFile(Path_TestData + File_TestData, "Input");
		       System.out.println("excel "+Path_TestData + File_TestData);
				setCellData(Actmetatitle, i, 3);
				
//				String ActulMetaTitle=getCellData(i, 3);
//				System.out.println("Actual "+ActulMetaTitle  );
			
				String Extdatameta = getCellData(i,3);
			System.out.println("exp "+Extdatameta);

			System.out.println("act "+Actdescription);
			
			if(Actmetatitle.trim().equals(Extdatameta.trim()))
			{
				System.out.println("pass");
				setExcelFile(Path_TestData + File_TestData, "Input");
				setCellData("pass", i, 6);
				//Reporter.Reportlog("Pass", "Meta Title Url: "+getCellData(i,0) );
			}
			else
			{
				System.out.println("Fail");
				setExcelFile(Path_TestData + File_TestData, "Input");
				setCellData("Fail", i, 6);
				//Reporter.Reportlog("Fail", "Meta Title Url: "+getCellData(i,0) );
			}
			
			//Meta keyword
		// JOptionPane.showConfirmDialog(null, null);
		 Thread.sleep(5000);
		    String ActmetaKeyword =  driver.findElement(By.xpath("//*[@name='keywords']")).getAttribute("content");
		    System.out.println("abc2 "+ActmetaKeyword);
		    ////*[@name='title']
		    ////meta[@property='twitter:title']
		  //  Reporter.Reportlog("Done", "Reading metaTitle from Application");
		    setExcelFile(Path_TestData + File_TestData, "Input");
				setCellData(ActmetaKeyword, i, 8);
				
//				String ActulMetaTitle=getCellData(i, 3);
//				System.out.println("Actual "+ActulMetaTitle  );
			
			String Extkeywrd = getCellData(i,7);
			System.out.println("exp "+Extkeywrd);

			System.out.println("act "+Actdescription);
			
			if(ActmetaKeyword.trim().equals(Extkeywrd.trim()))
			{
				System.out.println("pass");
				setExcelFile(Path_TestData + File_TestData, "Input");
				setCellData("pass", i, 9);
				//Reporter.Reportlog("Pass", "Meta Title Url: "+getCellData(i,0) );
			}
			else
			{
				System.out.println("Fail");
				setExcelFile(Path_TestData + File_TestData, "Input");
				setCellData("Fail", i, 9);
				//Reporter.Reportlog("Fail", "Meta Title Url: "+getCellData(i,0) );
			}

			
		}catch(Exception e) {
					
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



