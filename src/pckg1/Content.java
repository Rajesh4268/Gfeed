package pckg1;

import java.io.FileInputStream;
import java.io.FileOutputStream;

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

//import Glib.Glib;
//import bBScripts_withHtmlReport.Reporter;

public class Content {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "F:\\COMERCPUNDIT19\\Cp2020\\src\\testData\\";
	public static final String File_TestData = "11Covnewcontnt.xlsx";
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void main(String[] args) throws Throwable {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\Chromdrivr\\chromedriver.exe\\");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   Reporter.initialize();
		for(int i=1;i<=2;i++)
		{
			try {
			setExcelFile(Path_TestData + File_TestData,"Sheet1");
			String getexcelurl = getCellData(i,0);
			driver.get(getexcelurl);
			System.out.println( i +"getexcelurl "+getexcelurl);
			Reporter.Reportlog(driver,"Done", "Launching Url is "+getexcelurl);
			Reporter.loginfo("Pass");
			
			}catch(Exception e) {
				
			}
			//driver.switchTo().window(currentWindowHandle);
			//driver.close();
			//-description
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;


	        WebElement Element = driver.findElement(By.xpath("//*[@class='new-content']"));

	        //This will scroll the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Element);

			String descriptn = driver.findElement(By.xpath("//*[@class='new-content']")).getText();
	        //Find element by link text and store in variable "Element"        		
	
			//JOptionPane.showConfirmDialog(null, null);
			//Reporter.Reportlog("Test", "Testig");
//			//.getAttribute("innerHTML");
//			//////*[@itemprop='description']
//			System.out.println("Actualshortdes "+Actualshortdes);
//			setExcelFile(Path_TestData + File_TestData, "Sheet1");
//			setCellData(Actualshortdes, i, 1);
//			setExcelFile(Path_TestData + File_TestData, "Sheet1");
//			String getExptext = getCellData(i, 7);
//			System.out.println("getExptext "+getExptext);
//			String Expshortdes = getExptext;
			
			//--- get excel expected data
			Thread.sleep(3000);
			setExcelFile(Path_TestData + File_TestData, "Sheet1");
			setCellData(descriptn, i, 2);
			//Reporter.Reportlog("Done", "Exptext is "+Expshortdes10);
			String GetActual = descriptn;
			//Reporter.Reportlog("Done", "Exptext is "+getExptext);
		//	System.out.println("GetActual "+GetActual);
			

			String Expected = getCellData(i, 1);
	//		System.out.println("data frm excel "+Expected);
			
//			System.out.println("Act "+Actualshortdes10);
//			String Expshortdes10 = getExptext;
//			System.out.println("exp "+Expshortdes10);
		//	Glib.ReportScreenshot(driver, Expshortdes10);
		

			//--- compare using tool
//			driver.findElement(By.xpath("(//*[@class='box p-10 p-md-20'])[1]")).sendKeys(Expshortdes10.trim());
//			driver.findElement(By.xpath("(//*[@class='box p-10 p-md-20'])[2]")).sendKeys(Actualshortdes10.trim());
//			Thread.sleep(5000);
		//	String gettoolresult = driver.findElement(By.xpath("")).getText();
		//	System.out.println("gettoolresult "+gettoolresult);
			//---write capture screenshot method
			//--- ----

			if(GetActual.trim().replaceAll("[ \\t\\n\\r]*" , "").equalsIgnoreCase(Expected.trim().replaceAll("[ \\t\\n\\r]*", "")))
//			if((GetActual.trim().replaceAll(" ", "")).equalsIgnoreCase(Expected.trim()))
			{
				
				System.out.println("GetActual "+GetActual.trim().replaceAll("[ \\t\\n\\r]*" , ""));
				System.out.println("data frm excel "+Expected.trim().replaceAll("[ \\t\\n\\r]*", ""));	
				setExcelFile(Path_TestData + File_TestData, "Sheet1");
				setCellData("pass", i, 3);
				Thread.sleep(1000);
				System.out.println("pass");
			//	Reporter.Reportlog("Pass", "No Description in " + getCellData(i,0) );
					
				//
			}
			else
			{
				
					
				System.out.println("GetActual "+GetActual.trim().replaceAll("[ \\t\\n\\r]*" , ""));
				System.out.println("data frm excel "+Expected.trim().replaceAll("[ \\t\\n\\r]*", ""));	
				setExcelFile(Path_TestData + File_TestData, "Sheet1");
				setCellData("Fail", i, 3);
				System.out.println("Fail");
			//	Reporter.Reportlog("Fail", "Actual Text is not as expected");
			//	Reporter.Reportlog("Fail", "Description found in " + getCellData(i,0) );
				
			}
}catch (Exception e) {
			//--- blank text
//drivertool.findElement(By.xpath("")).sendKeys("");
//drivertool.findElement(By.xpath("")).sendKeys("");
//Thread.sleep(5000);

		

			}
//			//---shot description
//			try{
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//
//				WebElement ele1 = driver.findElement(By.xpath("//*[@class='bullet-point']"));
//				js.executeScript("arguments[0].scrollIntoView();", ele1);
//			//	JOptionPane.showConfirmDialog(null, null);
//				//Reporter.Reportlog("Test1", "text");
//	//			String descriptn = driver.findElement(By.xpath("//div[@id='productdescription-pane-1']")).getText();
//			
//			String Actualshortdes1 = driver.findElement(By.xpath("//*[@class='bullet-point']")).getText();
//			Thread.sleep(3000);
//
//			setExcelFile(Path_TestData + File_TestData, "Sheet1");
//			setCellData(Actualshortdes1, i, 4);
////			String Expshortdes1 = getCellData(i, 3);
////			System.out.println("getExptext "+Actualshortdes1);
//////			setExcelFile(Path_TestData + File_TestData, "Sheet1");
//////			String setCellData = getCellData(i, 3);
////			//System.out.println("getExptext "+setCellData);
//////			String Expshortdes = getExptext;
////			System.out.println("Actualshortdes1 "+Actualshortdes1);
////			
//			setExcelFile(Path_TestData + File_TestData, "Sheet1");
//			String getExptext1 = getCellData(i, 4);
//			System.out.println("getExptext1 "+getExptext1);
//			//Reporter.Reportlog("Done", "Actual Text is as expected" + getExptext1 );
//			String Expshortdes12 = Actualshortdes1;
////			
//			if(Actualshortdes1.trim().equalsIgnoreCase(getExptext1.trim()))
//			{
//				System.out.println("pass");	
//				setExcelFile(Path_TestData + File_TestData, "Sheet1");
//				setCellData("pass", i, 5);
//				
//			//	Reporter.Reportlog("Pass", "No Keypoints in " + getCellData(i,0) );
//				//Reporter.Reportlog("pass", "Actual Text is as expected");
//			}
//			else
//			{
//				System.out.println("fail");
//				setExcelFile(Path_TestData + File_TestData, "Sheet1");
//				setCellData("pass", i, 5);
//			//Reporter.Reportlog("fail", "Actual Text is not as expected");
//				//
//				//Reporter.Reportlog("Fail", " Keypoints in " + getCellData(i,0) );
//			}
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//try {
			//public static void clickjavascriptelement(WebDriver driver, WebElement element){

				
		//	}				
//Actions Act=new Actions(driver);
//Specification

			//JOptionPane.showConfirmDialog(null, null);
			//Reporter.Reportlog("Test", "Testig");
//try {
//
//JavascriptExecutor js = (JavascriptExecutor)driver;
//
//WebElement el=driver.findElement(By.xpath("//*[@id='productdescription-tab-2']"));
////executor.executeScript("arguments[0].click();", el);
//js.executeScript("arguments[0].scrollIntoView();", el);
//js.executeScript("arguments[0].click();", el);
////JOptionPane.showConfirmDialog(null, null);
////Reporter.Reportlog("Test", "Testig");
////Act.moveToElement(el).click();
////wait.until(ExpectedConditions.elementToBeClickable(el));
//Thread.sleep(3000);
//
//String prductspecf=driver.findElement(By.xpath("//div[@id='productdescription-pane-2']")).getText();
////JOptionPane.showConfirmDialog(null, null);
//Thread.sleep(3000);
////Reporter.Reportlog("Pass", "jopdat rtex");
//setExcelFile(Path_TestData + File_TestData, "Sheet1");
//setCellData(prductspecf, i, 3);
//setExcelFile(Path_TestData + File_TestData, "Sheet1");
//String getExptext3 = getCellData(i, 3);
//System.out.println("getExptext3 "+getExptext3);
//String Expprductspecf = prductspecf;
//System.out.println(""  + Expprductspecf);
////Reporter.Reportlog("Done", "Expected product spec.. is "+Expprductspecf);
//////
//if(prductspecf.trim().equalsIgnoreCase(getExptext3.trim())  )
//{
//System.out.println("pass");	
//setExcelFile(Path_TestData + File_TestData, "Sheet1");
//setCellData("pass", i, 4);
////Glib.ReportScreenshot(driver, prductspecf);
////Reporter.Reportlog("Pass",  " product specification "  +getCellData(i,0));
//}
//else
//{
//System.out.println("fail");
//setExcelFile(Path_TestData + File_TestData, "Sheet1");
//setCellData("Fail", i, 4);
////Glib.ReportScreenshot(driver, prductspecf);
////Reporter.Reportlog("Fail", "Actual Text is not as expected");
//
//}
//}catch(Exception e) {
////e.printStackTrace();
//}

}
		Reporter.writeResults();

		}
	
		
		// TODO Auto-generated method stub

	


//public static boolean shortwaitForVisisble(By byType) {
//	try {
//	WebDriverWait shortwait=new WebDriverWait(driver, 50);
//	shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(byType)));
//}	catch(Exception e) {
//		
//	}
//	
//	return driver.findElement(byType).isDisplayed();
//		
//	
//}

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



