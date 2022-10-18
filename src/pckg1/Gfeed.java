package pckg1;

//package Pck404;

//package Abcd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
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
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.tools.javac.util.List;

public class Gfeed {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "C:\\Users\\rajesh.r\\Desktop\\TestData\\";
	public static final String File_TestData = "14OctGfeedpart1_22.xlsx";
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		String currentDirectory = "C:\\Users\\rajesh.r\\Desktop\\TestData\\";
		//String currentDirectory = "F:\\Speedtest";
//		System.out.println("data "+currentDirectory);
//		System.setOut(new PrintStream(new FileOutputStream(currentDirectory+"\\consolelog.txt")));
//		
		
//		setExcelFile(Path_TestData + File_TestData, "Sheet1");
//		System.out.println(Path_TestData + File_TestData);
////		setCellData("abc1", 3, 3);
//		String da = "'data1";
//		System.out.println(da);
//		setCellData(da, 3, 3);
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajesh.r\\Desktop\\chrome\\chromedriver.exe\\");
	 //  WebDriver driver = new ChromeDriver();
	// Headless 
	  ChromeOptions options = new ChromeOptions();
     options.addArguments(new String[] { "--test-type" });
      options.setHeadless(true); 
     WebDriver driver = new ChromeDriver(options);
	 //   HtmlUnitDriver driver = new HtmlUnitDriver();
		//HtmlUnitDriver driver = new HtmlUnitDriver();
		 // WebDriver driver = new ChromeDriver();
//		   ChromeOptions options = new ChromeOptions();
//		   options.addArguments("enable-features=NetworkServiceInProcess");
		   //driver = new ChromeDriver(options);
		//   driver.manage().window().maximize();
////		    
		   
		   WebDriverWait wait = new WebDriverWait(driver, 10);
		    
		//	
			
			try {
				long time=System.currentTimeMillis();	
				for (int i=1;i<=3;i++ )
					//FileOutputStream. close();5551
				{	
			//FileOutputStream. close();	
//					setExcelFile(Path_TestData + File_TestData, "Sheet1");
////					String getRun = getCellData(i, 0);

//					if (getRun.trim().equalsIgnoreCase("Yes")) {
			try {
				setExcelFile(Path_TestData + File_TestData, "Input");
			//	driver.navigate().to("getexcelurl");
				String getexcelurl = getCellData(i, 0);
				System.out.println(i  +  getexcelurl );
				
				//JOptionPane.showConfirmDialog(null, getexcelurl);
				//driver.navigate().to(getexcelurl);
			//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@itemprop='price']")));
				
				driver.get(getexcelurl);
				 Actions action = new Actions(driver);
				 action.sendKeys(Keys.ESCAPE).build().perform();
				 driver.findElement(By.xpath("//button[@alt='Close form']")).click();
//				waitForLoaderToDisMiss(driver);
//				Thread.sleep(2000);
//				WebElement subtotal = driver.findElement(By.xpath("//*[@itemprop='price']"));
//				System.out.println("price is " + subtotal );
//				String getdata1 = subtotal.getAttribute("content").replace("£", "");
				
				//getdata.replace("£", "");
//				System.out.println(" meta price is " + getdata1 );
//				setExcelFile(Path_TestData + File_TestData, "Input");
//				setCellData(getdata1, i, 5);
			//	Reporter.Reportlog("Done", "Fetch URL from Excel : "+getexcelurl);
//		    System.out.println(i+" "+getexcelurl);	
//		    try {
//		    WebDriverWait wait = new WebDriverWait(driver, 2);
//		   	wait.until(ExpectedConditions.elementToBeClickable
//						(By.xpath("//a[@class='closebtn']")));
//				Thread.sleep(3000);
//				driver.findElement(By.xpath("//a[@class='closebtn']")).click();
//				System.out.println("popup closed");
////				
////				wait.until(ExpectedConditions
////						.invisibilityOfElementLocated(By.xpath("(//div[@class='instanceLoaderBox']//img")));
//				Thread.sleep(5000);
//				WebElement RecommendedCategories=driver.findElement(By.xpath("(//div[@class='pageTitleBox'])[4]"));
//				if(getexcelurl.contentEquals(RecommendedCategories)) {
//					
			}catch (Exception e)
		    {
//					e.printStackTrace();
		    }
//				if(driver.getCurrentUrl().contains("404")) 
//				{
//					  System.out.println("Fail "+ driver.getCurrentUrl() +" contains  404");
//					//  Reporter.Reportlog("Fail", driver.getCurrentUrl() +" contains  404");
//					  String url=driver.getCurrentUrl();
//					  System.out.println("broken url is"+ url );
//					//  Reporter.Reportlog("Done", "broken url is"+ url );
//					  setExcelFile(Path_TestData + File_TestData, "Input");
//						setCellData(url, i, 5);
//					  
//				}
//				else 
//				{
					try
					{
//							
//				//waitForLoaderToDisMiss2(driver);
////				try
////				{
////				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='fotorama__spinner fotorama__spinner--show']")));	
////				System.out.println("wait fr ");
////				}
////				catch(Exception e)
////				{
////					System.out.println("presenceOfElementLocated unable to find");
////				}
//				
//					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='fotorama__spinner fotorama__spinner--show']")));		
//						
//				
//					System.out.println("invisibilityOfElementLocatedfind");
//				
//				
//				try {
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'RATE US')]")));
//				}
//				catch(Exception e)
//				{
//					System.out.println("visibilityOfElementLocated unable to find");
//				}
//			
//				Thread.sleep(3000);
//				System.out.println("side loader Exist");
////				WebElement subtotal = driver.findElement(By.xpath("//span[@data-price-type='finalPrice']"));
//				String getdata = subtotal.getText().replace("£", "");
			//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@src='/static/images/store/3/MiniLoader.gif']")));
				Thread.sleep(2000);
				//getdata.replace("£", "$");
				String	getdata = driver.findElement(By.xpath("//*[@class='newPrice '] |//*[@class='newPrice']")).getText();
				getdata.replace("£", "");
				//getdata
				System.out.println("price is " + getdata );
				//bb>>//span[@itemprop='price']
				//(//span[@class='price-wrapper price-including-tax'])[1]
				setCellData(getdata, i, 2);
				System.out.println("Actual data " + getdata);
				
				System.out.println("Actual price "+getdata);
				if(getdata.trim().equals("0.00"))		
				{
					System.out.println("Fail"+ getdata);
					//Reporter.Reportlog("Fail", "Actual price "+getdata );
				}
				else
				{
					System.out.println("Pass"+ getdata);
					//Reporter.Reportlog("Pass", "Actual price "+getdata );
				}
				
				String getexpprice = getCellData(i, 4);
			//
				System.out.println("expected price" + "£"+getexpprice);
			///	Reporter.Reportlog("Done", "expected price" + getexpprice);

	//=----covert actual application value to double
				
				String actprice= getdata.trim();
				//double actprice1= Double.parseDouble(getdata1);
				
				//double actprice1= Double.parseDouble(getdata);
	//---Convert expected excel value to double
				String expprice= "$"+getexpprice;
				//String expprice1= ""+etexpprice;
				//£,$
				System.out.println("expprice.trim()abc "+expprice.trim());
		//		System.out.println("actprice.trim() "+actprice.trim());
				String getfactdata = actprice.trim().replace("(Incl. VAT)", "");
				System.out.println("actprice.trim()abc "+getfactdata.trim());
				if(getfactdata.trim().equalsIgnoreCase(expprice.trim()))
				{
					System.out.println("pass double");
					setCellData("Pass", i, 3);
		//			CellStyle style = ExcelWBook.createCellStyle();
					//style.setCe
//					style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
//					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
//					System.out.println("pass")
				}
				else
				{
					System.out.println("fail double");
					setCellData("Fail", i, 3);
//					System.out.println("pass")
				}
				
				
				System.out.println("TIme taken in secs: " + i  +" "+(System.currentTimeMillis()-time)/1000);			
//				System.out.println("system time " + System.currentTimeMillis());
//				System.out.println(" time " + time);
//					//JOptionPane.showMessageDialog(null, null);
				
				////span[@itemprop='price']
			//	(//span[@class='price'])[1]
				
		//(//div[@class='pageTitleBox'])[4]
		////*[@class='newPrice']
				//RecommendedCategoriesstyled-sc-1o0l76g-0 kTjITk
//				setExcelFile(Path_TestData + File_TestData, "Input");
//				setCellData(getdata, i, 1);
//				String getactpric=getCellData(i, 2);
//				System.out.println("Actual price  "+getactpric  );
			//	Reporter.Reportlog("Done", "Actual price  "+getactpric);
					} catch (Exception e) {
					      System.out.println("Fail Something went wrong. "+driver.getCurrentUrl());
					   //   Reporter.Reportlog("Fail", "Something went wrong. "+ driver.getCurrentUrl());
					      
					    }

					///Expected price from excel
					
					
					
		//---compare both double value with pass or fail usinf if condition			
					
					
					
					
					
//					if((getCellData(i, 2)).trim().equalsIgnoreCase(getexpprice.trim()))
//					{
////						
//					setExcelFile(Path_TestData + File_TestData, "Input");
//						setCellData("Pass", i, 3);
//						System.out.println("pass");
//					//	Reporter.Reportlog("Pass", "Actual Result is as expected");
//					}
//				 else 
//					{
//						setExcelFile(Path_TestData + File_TestData, "Input");
//						setCellData("Fail", i, 3);
//						System.out.println("Fail");
//						//Reporter.Reportlog("Fail","Actual Result is not as expected");
//					}
					//FileOutputStream. close();
						
			}}catch(Exception e) {
						throw (e);
						
					}
		//	FileOutputStream. close();
						
						}

//		Thread.sleep(10000);
		
		///--launch url and verify price
		
		
		
		
		
		
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

		}}
