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

public class BBmeta {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "F:\\COMERCPUNDIT19\\Cp2020\\src\\testData\\";
	public static final String File_TestData = "15BBNewseptmeta.xlsx";
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\Chromdrivr\\chromedriver.exe\\");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   Reporter.initialize();
		// TODO Auto-generated method stub
		setExcelFile(Path_TestData + File_TestData,"Input");
		Reporter.initialize();
		for(int i=1;i<=160;i++)
		{
			try {
				Thread.sleep(2000);
			String url = getCellData(i,0);	
//		driver.get("https://testgm.signsigma.com/1x3-micro-geometrix-table-top-display.html");
			driver.get(url);
			 System.out.println(i+" "+url);
//			 Reporter.Reportlog("Done", "Url : "+url );
////		TimeUnit.SECONDS.sleep(5);
//		driver.get("https://www.w3docs.com/tools/code-diff/");
	}catch(Exception e) {
				
			}
		//META DESCRIPT	
			try {
		String Actdescription = driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content");
		System.out.println(Actdescription);
		//getAttribute("content")
		//Reporter.Reportlog("Done", "Reading metadata from Application");
		//String Actdescripti=getCellData(i, 2);
		setExcelFile(Path_TestData + File_TestData, "Input");
		setCellData(Actdescription, i, 4);
		
//		System.out.println("exp  "+Actdescription);
//		String getexpprice = getCellData(i, 4);
//		System.out.println("exp  "+getexpprice);
		
			
		
		//---
		
		String Extdata = getCellData(i,2);
		System.out.println("exp "+Extdata);

		System.out.println("act "+Actdescription);
		
		if(Actdescription.trim().equals(Extdata.trim()))
		{
			System.out.println("pass");
			setExcelFile(Path_TestData + File_TestData, "Input");
			setCellData("Pass", i, 5);
			Reporter.Reportlog(driver,"pass MetaDescriptin", "Launching Url is "+getCellData(i,0));
		}
		else
		{
			System.out.println("fail");
			setExcelFile(Path_TestData + File_TestData, "Input");
			setCellData("Fail", i, 5);
			Reporter.Reportlog(driver,"Fail MetaDescriptin", "Launching Url is "+getCellData(i,0));
			
		}
//		JOptionPane.showConfirmDialog(null, null);
//		Thread.sleep(5000);
		//---metatitle
			
	    //   String Actmetatitle =  driver.findElement(By.xpath("//title[@class='next-head']"));
		 String Actmetatitle =driver.getTitle() ;
	       System.out.println("abc1 "+Actmetatitle);
	       ////*[@name='title']
	     //title[@class='next-head']
	       ////meta[@property='twitter:title']
	     //  Reporter.Reportlog("Done", "Reading metaTitle from Application");
	       setExcelFile(Path_TestData + File_TestData, "Input");
			setCellData(Actmetatitle, i, 3);
			
//			String ActulMetaTitle=getCellData(i, 3);
//			System.out.println("Actual "+ActulMetaTitle  );
		
		String Extdatameta = getCellData(i,1);
		System.out.println("exp "+Extdatameta);

		//System.out.println("act "+Actdescription);
		
		if(Actmetatitle.trim().equals(Extdatameta.trim()))
		{
			System.out.println("pass");
			setExcelFile(Path_TestData + File_TestData, "Input");
			setCellData("pass", i, 6);
			Reporter.Reportlog(driver,"pass MetaTitle", "Launching Url is "+getCellData(i,0));
		}
		else
		{
			System.out.println("Fail");
			setExcelFile(Path_TestData + File_TestData, "Input");
			setCellData("Fail", i, 6);
			Reporter.Reportlog(driver,"Fail MetaTitle", "Launching Url is "+getCellData(i,0));
		}
		
		//Meta keyword
	// JOptionPane.showConfirmDialog(null, null);
	 Thread.sleep(3000);
	    String ActmetaKeyword =  driver.findElement(By.xpath("//*[@name='keywords']")).getAttribute("content");
	    System.out.println("abc2 "+ActmetaKeyword);
	    ////*[@name='title']
	    ////meta[@property='twitter:title']
	  //  Reporter.Reportlog("Done", "Reading metaTitle from Application");
	    setExcelFile(Path_TestData + File_TestData, "Input");
			setCellData(ActmetaKeyword, i, 8);
			
//			String ActulMetaTitle=getCellData(i, 3);
//			System.out.println("Actual "+ActulMetaTitle  );
		
		String Extkeywrd = getCellData(i,7);
		System.out.println("expKeywrd  "+ Extkeywrd);

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
			//Reporter.Reportlog(driver,"Done", "Launching Url is "+getCellData(i,0));
		}

		
	}catch(Exception e) {
//				
	}
		
		}
		Reporter.writeResults();
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




