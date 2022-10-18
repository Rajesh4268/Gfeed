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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import bBScripts_withHtmlReport.Reporter;

public class UK_Shippingfeed {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "F:\\COMERCPUNDIT19\\Cp2020\\src\\testData\\";
	public static final String File_TestData = "1ukshipfeed.xlsx";
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	public static void main(String[] args) throws Exception {
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\Chromdrivr\\chromedriver.exe\\");
		   WebDriver driver = new ChromeDriver();
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 30);
		 
		for(int i=1033;i<=1187;i++)
		{
			//try {
			long time=System.currentTimeMillis();
			
			setExcelFile(Path_TestData + File_TestData,"Input");
			String getexcelurl = getCellData(i, 0);
			try {

			driver.get(getexcelurl);
			System.out.println( i   +  "getexcelurl "+ getexcelurl);
			 driver.manage().window().maximize();
			//Reporter.Reportlog("Done", "Launching Url is "+getexcelurl);
			 Actions action = new Actions(driver);
			 action.sendKeys(Keys.ESCAPE).build().perform();
			 driver.findElement(By.xpath("//button[@alt='Close form']")).click();
			}catch(Exception e) {
				
			}
			
			//waitForLoaderToDisMiss2(driver);
			
			//JOptionPane.showConfirmDialog(null, null);
			//WebDriverWait wait = new WebDriverWait(driver, 30);
			try {
				
				if(driver.findElements(By.xpath("//span[text()='Upload Artwork']")).size()>0)
					System.out.println("Size is  " + driver.findElements(By.xpath("//span[text()='Upload Artwork']| (//span[@class='labeltext'])[2]")).size());
				{
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Upload Artwork']")));
					//wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//span[text()='Upload Artwork']")));
					// userdefinedDynamicwait(30,"//span[text()='Upload Artwork']");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Upload Artwork']| (//span[@class='labeltext'])[2]")));
			Thread.sleep(2000);
			//shortwaitForVisisble((By.xpath("//span[text()='Upload Artwork']")));
			clickjavascriptelement(driver, driver.findElement(By.xpath("//span[text()='Upload Artwork']| (//span[@class='labeltext'])[2]")));
				}
			} catch (Exception e1)
			{
				
			}	
		try {
			if(driver.findElements(By.xpath("//span[text()='Upload Artwork'] | //button[text()='Add To Cart'] | //button[contains(text(),'Proceed & Checkout')]")).size()>0)
				System.out.println("Size is  " + driver.findElements(By.xpath("//span[text()='Upload Artwork'] | //button[text()='Add To Cart'] | //button[contains(text(),'Proceed & Checkout')] ")).size());
			{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add To Cart'] | //button[contains(text(),'Proceed & Checkout')] | //button[text()='UPLOAD ARTWORK & CHECKOUT']|//button[text()='Upload Artwork & Checkout']")));
//////				//JOptionPane.showConfirmDialog(null, null);
//////				//Thread.sleep(5000);
//////			// userdefinedDynamicwait(30,"//button[text()='Add To Cart'] | //button[contains(text(),'Proceed & Checkout')] | //button[text()='Upload Artwork & Checkout']");
			//shortwaitForVisisble((By.xpath("//button[text()='Add To Cart'] | //button[contains(text(),'Proceed & Checkout')] | //button[text()='UPLOAD ARTWORK & CHECKOUT']")));
			
			clickjavascriptelement(driver, driver.findElement(By.xpath("//button[text()='Add To Cart'] | //button[contains(text(),'Proceed & Checkout')] | //button[text()='UPLOAD ARTWORK & CHECKOUT']|//button[text()='Upload Artwork & Checkout']")));
			}
			} catch (Exception e1)
		{
		}
			
			
			try {
				
				
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btnpopupclose']")));
			Thread.sleep(2000);
			clickjavascriptelement(driver,driver.findElement(By.xpath("//button[@class='btnpopupclose']")));
			//shortwaitForVisisble((By.xpath("//button[@class='btnpopupclose']")));
			
			clickjavascriptelement(driver,driver.findElement(By.xpath("//button[text()='Add To Cart']")));
			}catch(Exception e) {
				e.printStackTrace();
			}

		
		//CHoice between Add to cart, Proceed & Checkout and UPload artwork
//		WebElement elementToClick=null;
//		try {
//			By addToCard=(By.xpath("//button[text()='Add To Cart']"));
//			shortwaitForVisisble(addToCard);
//			elementToClick=driver.findElement(addToCard);
//			
//		}catch(Exception e) {}
	//	
//		if(elementToClick==null) {
//		try {
//			By addToCard=(By.xpath("//button[contains(text(),'Proceed & Checkout')]"));
//			shortwaitForVisisble(addToCard);
//			elementToClick=driver.findElement(addToCard);
//			
//		}catch(Exception e) {}
//		}
	//	
//		if(elementToClick==null) {
//		try {
//			By addToCard=(By.xpath(" //button[text()='Upload Artwork & Checkout']"));
//			shortwaitForVisisble(addToCard);
//			elementToClick=driver.findElement(addToCard);
//			
//		}catch(Exception e) {}
//		}
//		clickjavascriptelement(driver, elementToClick);
	//	
		
//		try {
//			//Thread.sleep(2000);
//		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btnpopupclose']")));
//		shortwaitForVisisble((By.xpath("//button[@class='btnpopupclose']")));
//		clickjavascriptelement(driver,driver.findElement(By.xpath("//button[@class='btnpopupclose']")));
//		//Thread.sleep(2000);
////		clickjavascriptelement(driver, driver.findElement(By.xpath("//button[text()='Add To Cart'] | //button[contains(text(),'Proceed & Checkout')] | //button[text()='Upload Artwork & Checkout']")));
	//	
//		//clickjavascriptelement(driver,driver.findElement(By.xpath("//button[text()='Add To Cart']")));
////		if(popup.isDisplayed()) {
////			
////			clickjavascriptelement(driver,popup);
////		}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//				
//			}
			//waitForLoaderToDisMiss(driver);
			try {
				//JOptionPane.showConfirmDialog(null, null);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btnSecondaryOne addToCartAfterOrderBtn']")));
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btnSecondaryOne addToCartAfterOrderBtn']")));
			//Thread.sleep(6000);
				//shortwaitForVisisble((By.xpath("//button[@class='btn btnSecondaryOne addToCartAfterOrderBtn']")));

				Actions act=new Actions(driver);
				WebElement el=driver.findElement(By.xpath("//button[@class='btn btnSecondaryOne addToCartAfterOrderBtn']"));
				//JOptionPane.showConfirmDialog(null, null);
				Thread.sleep(1000);
				act.moveToElement(el).build().perform();
		
				clickjavascriptelement(driver, driver.findElement(By.xpath("//button[@class='btn btnSecondaryOne addToCartAfterOrderBtn']")));

			}catch(Exception e)
				{
				e.printStackTrace();
					System.out.println("Add to card buttn is not succesfull");

				}	
		try
		{
			//waitForLoaderToDisMiss(driver);
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btnSecondaryOne addToCartAfterOrderBtn']")));
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@class='linkButton remove']")));
			////button[text()='Proceed to checkout']
			//select super saver
			//shortwaitForVisisble(By.xpath("/*[@id='cartsummary-heading-2']/div/a"));
	    	
			clickjavascriptelement(driver,driver.findElement(By.xpath("//*[@id='cartsummary-heading-2']/div/a")));
		     JavascriptExecutor jse = (JavascriptExecutor)driver;
		      jse.executeScript("window.scrollBy(0,360)");
		 //      WebElement supersaver= driver.findElement(By.xpath("//span[text()='Super Saver']"));
		   //    clickjavascriptelement(driver,rb);
		  //     WebElement priority= driver.findElement(By.xpath("//span[text()='Super Saver']"));
		     //  waitForLoaderToDisMiss(driver);
		      // Thread.sleep(4000);
			//Select express
//			
//			clickjavascriptelement(driver,driver.findElement(By.xpath("//*[@id='cartsummary-heading-2']/div/a")));
//		      JavascriptExecutor jse = (JavascriptExecutor)driver;
//		       jse.executeScript("window.scrollBy(0,360)");
//		       WebElement rb= driver.findElement(By.xpath("//span[text()='Express']"));
//		       clickjavascriptelement(driver,rb);
//		       waitForLoaderToDisMiss(driver);
//		       Thread.sleep(5000);
		       //shortwaitForVisisble(By.xpath("//*[@id='__next']/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/span[2]"));
//		    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/span[2]")));
//		    	shortwaitForVisisble(By.xpath("//*[@id='__next']/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/span[2]"));
		    	
		    	//TimeUnit.SECONDS.sleep(5);
		   //	JOptionPane.showConfirmDialog(null, null);
			    Thread.sleep(3000);
			    String getsubtotal = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Subtotal'])[1]/following::span[1]")).getText();
				String getsubtotal1=getsubtotal.replace("£", "");
				System.out.println("Actual sub total price in string "+getsubtotal1);
				Double actsubtotaldouble = Double.parseDouble(getsubtotal1.trim());
				//Express
				String getdata = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Express'])[1]/following::span[2]")).getText();
				String getdata1=getdata.replace("£", "");
				System.out.println("Actual Express price in string "+getdata1);
				Double actpricedouble = Double.parseDouble(getdata1.trim());
				//priority
				String priority = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Priority'])[1]/following::span[2]")).getText();
				String priority1=priority.replace("£", "");
				System.out.println("Actual priority price in string "+priority1);
				Double actpricedouble1 = Double.parseDouble(priority1.trim());
				System.out.println("Actual price in double "+actpricedouble);
				System.out.println("Data from Excel1 :" + getCellData(i, 1));
		    if(actsubtotaldouble<=99.00)
		    {
				setExcelFile(Path_TestData + File_TestData, "Input");
				setCellData(getdata1, i, 2);
				
				if(getCellData(i, 4).trim().equalsIgnoreCase(getdata1.trim()) )
					
					   {
					System.out.println("Data from Excel1 express :" + getCellData(i, 4));
						System.out.println("pass less than 99");
					   setExcelFile(Path_TestData + File_TestData, "Input");
						setCellData("Pass", i, 3);
						//	Reporter.Reportlog("Pass", "Url is "+   getexcelurl);	
							
								
						}
						else
						{
							System.out.println("Data from Excel express :" + getCellData(i, 4));
							System.out.println("fail less than 99");
							setExcelFile(Path_TestData + File_TestData, "Input");
							setCellData("Fail", i, 3);
							//Reporter.Reportlog("Fail", "Url is "+   getexcelurl);
						}

		    }
		    else if(actsubtotaldouble>99.00)
		    {
				setExcelFile(Path_TestData + File_TestData, "Input");
				setCellData(priority1, i, 2);
				System.out.println("expected Priority cell "+getCellData(i, 4));
				if(getCellData(i, 4).trim().equalsIgnoreCase(priority1.trim()))
			    	{									
						System.out.println("pass greater than 99");
					   setExcelFile(Path_TestData + File_TestData, "Input");
						setCellData("Pass", i, 3);
						//	Reporter.Reportlog("Pass", "Url is "+   getexcelurl);	
							
								
						}
						else
						{
						
							System.out.println("fail greater than 99");
							setExcelFile(Path_TestData + File_TestData, "Input");
							setCellData("Fail", i, 3);
							//Reporter.Reportlog("Fail", "Url is "+   getexcelurl);
						}

		    }
			//TimeUnit.SECONDS.sleep(5);
			//JOptionPane.showConfirmDialog(null, null);
		//	shortwaitForVisisble(By.xpath("//*[@class='linkButton remove']"));
		  //  JOptionPane.showConfirmDialog(null, null);
		    Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='linkButton remove']")));

			
		}catch(Exception e)
		{
		}
		
		for(int m=1;m<=4;m++)
		{
		try {
			clickjavascriptelement(driver,driver.findElement(By.xpath("//*[@class='linkButton remove']")));
		Thread.sleep(2000);
		
		
		clickjavascriptelement(driver,driver.findElement(By.xpath("//*[@class='btn btnSecondaryOne btn btn-default']")));
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			System.out.println("delete buton not avaialble");
		}
		}
		
		
//		for(in)
//		{
//			//-delete xpah
//			
//			if(cartitems=0)
//			{
//				pass
//				break;
//			}
//	
//		}
		
		
		
		
		System.out.println("TIme taken in secs: "+(System.currentTimeMillis()-time)/1000);
	}
			
	}
	
	public static boolean shortwaitForVisisble(By byType) {
		try {
		WebDriverWait shortwait=new WebDriverWait(driver, 50);
		shortwait.until(ExpectedConditions.visibilityOf(driver.findElement(byType)));
}	catch(Exception e) {
			
		}
		
		return driver.findElement(byType).isDisplayed();
			
		
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




