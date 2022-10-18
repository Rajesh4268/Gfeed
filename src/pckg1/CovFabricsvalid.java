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

//import Glib.Glib;
//import bBScripts_withHtmlReport.Reporter;

public class CovFabricsvalid {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "F:\\COMERCPUNDIT19\\Cp2020\\src\\testData\\";
	public static final String File_TestData = "1covfabric.xlsx";
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void main(String[] args) throws Throwable {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\Chromdrivr\\chromedriver.exe\\");
		   WebDriver driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   Reporter.initialize();
		   WebDriverWait wait = new WebDriverWait(driver, 40);
			for(int i=1;i<=2;i++)
			{
				//try {
				
				setExcelFile(Path_TestData + File_TestData,"Input");
				String getexcelurl = getCellData(i, 0);
				try {

				driver.get(getexcelurl);
				System.out.println( i   +  "getexcelurl "+ getexcelurl);
				//Reporter.Reportlog("Done", "Launching Url is "+getexcelurl);
				
				}catch(Exception e) {
					
				}
				
				//waitForLoaderToDisMiss2(driver);
			try
				{
			//	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fotorama__spinner fotorama__spinner--show']")));	
			//	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fotorama__spinner fotorama__spinner--show']")));
				Thread.sleep(4000);
				//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@disabled='disabled']"))); 
				
				 JavascriptExecutor js = (JavascriptExecutor) driver;
				//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-value='option-label-color-92-item-111']")));
					//JOptionPane.showConfirmDialog(null, "waitscrollto1");
		//			js.executeScript("arguments[0].scrollIntoView();","//*[@id='tab-label-fabrics-title']");
					clickjavascriptelement(driver,driver.findElement(By.xpath("//*[@id='tab-label-fabrics-title']")));
					clickjavascriptelement(driver,driver.findElement(By.xpath("//*[@id='tab-label-fabrics-title']")));
					Thread.sleep(3000);
				//	JOptionPane.showConfirmDialog(null, null);
					WebElement covfab1=driver.findElement(By.xpath("(//*[@class='cover_max 5763'])[1]"));
					WebElement covfab2=driver.findElement(By.xpath("(//*[@class='cover_fab 5827'])[1]"));
					WebElement covfab3=driver.findElement(By.xpath("(//*[@class='cover_rite 5761'])[1]"));
					String covfab = covfab1.getText().trim()+covfab2.getText().trim()+covfab3.getText().trim();

					System.out.println("Data is " + covfab );
					setExcelFile(Path_TestData + File_TestData, "Input");
					setCellData(covfab, i, 1);
					setCellData("Pass", i, 2);
					//Reporter.Reportlog("Pass", "Frequently bought together  exist in page " +  getCellData(i,0) );
					//JOptionPane.showConfirmDialog(null, "waitscrollto");
			//	clickjavascriptelement(driver,driver.findElement(By.xpath("//*[@data-value='option-label-fabric_type-401-item-113']")));
					Thread.sleep(2000);
					//JOptionPane.showConfirmDialog(null, "wait");
				//	WebElement e1error = driver.findElement(By.xpath("//*[@data-value='option-label-color-92-item-111']"));
				//	WebElement e1error1 = driver.findElement(By.xpath("//*[@data-value='option-label-color-92-item-112']"));

					//WebElement ele1 = driver.findElement(By.xpath("//*[@class='productKeyPopintBox']"));
					//js.executeScript("arguments[0].scrollIntoView();", e1error);
				
//				System.out.println("Data is " + e1error.getText());
//				setCellData(e1error.getText(), i, 2);
//				System.out.println("Data1 is " + e1error1.getText() );
//				setCellData(e1error1.getText(), i, 3);
//				if((e1error.getText().trim().equals("Light Gray")) && (e1error1.getText().trim().equals("Light Sand")))
//				{
//				
//				setExcelFile(Path_TestData + File_TestData, "Input");
//				setCellData("Pass", i, 1);
//			//	Reporter.Reportlog("Pass", "Light Sand Light Gray exist in page " +  getCellData(i,0) );
//				}
//				else
//				{
//					setExcelFile(Path_TestData + File_TestData, "Input");
//					setCellData("Fail", i, 1);
//				///	Reporter.Reportlog("Fail", "Light Sand Light Gray exist in page " +  getCellData(i,0) );	
//				}
				
//				String data = driver.findElement(By.xpath("(//img[@itemprop='image'])[1]")).getAttribute("src");
//				System.out.println("d "+data);
				
				//---get all product name 
//				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@alt='Loading...']")));
//				List<WebElement>  prt= driver.findElements(By.xpath("//*[@class='product details product-item-details']"));
		//
//				
//				for(WebElement prt1: prt )
//				{
//					System.out.println(prt1.getText());
//				}
				

				}
				catch(Exception e)
				{
					setExcelFile(Path_TestData + File_TestData, "Input");
					setCellData("Fail", i, 2);
				//	Reporter.Reportlog("Fail", "Light Sand Light Gray exist in page  "  +  getCellData(i,0) );
					
				}
				

			//}
			}}
		//Reporter.writeResults();

		

		
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



