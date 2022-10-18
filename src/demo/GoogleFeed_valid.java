package demo;



//package Pck404;

//package Abcd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
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
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import com.sun.tools.javac.util.List;

public class GoogleFeed_valid {
	private static MissingCellPolicy xRow;
	public static WebDriver driver = null;
	public static final String Path_TestData = "F:\\COMERCPUNDIT19\\Cp2020\\src\\testData\\";
	public static final String File_TestData = "11JulyUk_22.xlsx";
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	public static HashMap<Integer,String> sh1;
	public static HashMap<Integer,String> sh1result;
	public static HashMap<Integer,String> sh2;
	public static HashMap<Integer,String> sh1actualresult;
	
	public static HashMap<Integer,String> sh1_thread2;
	public static HashMap<Integer,String> sh1result_thread2;
	public static HashMap<Integer,String> sh2_thread2;
	public static HashMap<Integer,String> sh1actualresult_thread2;
	public static Logger log;
	public static int TD1Strvalue;
	public static int TD1endvalue;
	public static int TD2Strvalue;
	public static int TD22endvalue;

	//public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
	static Callable<Void> callable1 = new Callable<Void>()
	   {
	      @Override
	      public Void call() throws Exception
	      {
	    	  try {
				readDataFromExcelsheet1();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         return null;
	      }
	   };

		static Callable<Void> callable2 = new Callable<Void>()
		   {
		      @Override
		      public Void call() throws Exception
		      {
		    	  try {
					readDataFromExcelsheet2();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         return null;
		      }
		   };
   
	   
	   
	   
	public static void feed(int da,int da1) {
		
//		setExcelFile(Path_TestData + File_TestData, "Sheet1");
//		System.out.println(Path_TestData + File_TestData);
////		setCellData("abc1", 3, 3);
//		String da = "'data1";
//		System.out.println(da);
//		setCellData(da, 3, 3);
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\Chromdrivr\\chromedriver.exe\\");
	   WebDriver driver = new ChromeDriver();
	    
	   // HtmlUnitDriver driver = new HtmlUnitDriver();
		//HtmlUnitDriver driver = new HtmlUnitDriver();
		 // WebDriver driver = new ChromeDriver();
//		   ChromeOptions options = new ChromeOptions();
//		   options.addArguments("enable-features=NetworkServiceInProcess");
		   //driver = new ChromeDriver(options);
		   driver.manage().window().maximize();
//		    
		   
		   WebDriverWait wait = new WebDriverWait(driver, 1);
		    
		//	
			
			try {
				long time=System.currentTimeMillis();	
				for (int i=da;i<=da1;i++ )
					//FileOutputStream. close();5551
				{	
			//FileOutputStream. close();	
//					setExcelFile(Path_TestData + File_TestData, "Sheet1");
////					String getRun = getCellData(i, 0);

//					if (getRun.trim().equalsIgnoreCase("Yes")) {
			try {
				setExcelFile(Path_TestData + File_TestData, "Input1");
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
				//Thread.sleep(2000);
				//getdata.replace("£", "$");
				String	getdata = driver.findElement(By.xpath("//span[@itemprop='price'] | //*[@class='newPrice']")).getText();
				getdata.replace("$", "");
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
				System.out.println("expected price" + "$"+getexpprice);
			///	Reporter.Reportlog("Done", "expected price" + getexpprice);

	//=----covert actual application value to double
				
				String actprice= getdata;
				//double actprice1= Double.parseDouble(getdata1);
				
				//double actprice1= Double.parseDouble(getdata);
	//---Convert expected excel value to double
				String expprice= "$"+getexpprice;
				//£,$
				System.out.println("expprice.trim() "+expprice.trim());
				System.out.println("actprice.trim() "+actprice.trim());
				if(actprice.trim().equalsIgnoreCase(expprice.trim()))
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

		}
      
		
		public static void readDataFromExcelsheet1() throws Throwable {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajesh.r\\Desktop\\chrome\\chromedriver.exe\\");
			 //  WebDriver driver = new ChromeDriver();
			// Headless 
				  ChromeOptions options = new ChromeOptions();
			     options.addArguments(new String[] { "--test-type" });
			      options.setHeadless(true); 
			      WebDriver driver = new ChromeDriver(options);
			      
			   sh1result = new HashMap<Integer,String>();
			   sh1actualresult = new HashMap<Integer,String>();
			 try {
				 
			for(int i=1;i<=5;i++) 
			{
				long time=System.currentTimeMillis();
				log.info("Url from Test data1 s.no: "+i+" "+sh1.get(1));
			driver.get(sh1.get(1));
			System.out.println("getmethodvalue "+sh1.get(i));
		
			Thread.sleep(2000);
			//getdata.replace("£", "$");
			String	getdata = driver.findElement(By.xpath("//span[@itemprop='price'] | //*[@class='newPrice']")).getText();
			getdata.replace("$", "");
			System.out.println("price is " + getdata );
		
			
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
			
			String getexpprice = sh2.get(i);
		//
			System.out.println("expected price" + "£"+getexpprice);
		///	Reporter.Reportlog("Done", "expected price" + getexpprice);

//=----covert actual application value to double
			
			String actprice= getdata;
			//double actprice1= Double.parseDouble(getdata1);
			
			//double actprice1= Double.parseDouble(getdata);
//---Convert expected excel value to double
			String expprice= "$"+getexpprice;
			//£,$
			System.out.println("expprice.trim() "+expprice.trim());
			sh1actualresult.put(i, actprice.trim()); 
			System.out.println("actprice.trim() "+actprice.trim());
			if(actprice.trim().equalsIgnoreCase(expprice.trim()))
			{
				System.out.println("pass double");
				sh1result.put(i, "pass");
//				setCellData("Pass", i, 3);
			}
			else
			{
				System.out.println("fail double");
				sh1result.put(i, "fail");
//				setCellData("Fail", i, 3);
//				System.out.println("pass")
			}
			System.out.println("Test data 1 Time taken in secs: " + i  +" "+(System.currentTimeMillis()-time)/1000);
			log.info("Test data 1 Time taken in secs: " + i  +" "+(System.currentTimeMillis()-time)/1000);			
			
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Result1");

			XSSFRow row = sheet.createRow(0);
			CellStyle style = workbook.createCellStyle();  
            // Setting Background color  
            style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());  
            style.setFillPattern(FillPatternType.BIG_SPOTS);  
            XSSFCell cell = row.createCell(1);  

			row.createCell(0).setCellValue("URL");
			row.createCell(1).setCellValue("Expected_Value");
			row.createCell(2).setCellValue("Actual_Value");
			row.createCell(3).setCellValue("Status");
					
			for(int k=1;k<=5;k++) {
			XSSFRow row1 = sheet.createRow(k);
			row1.createCell(0).setCellValue(sh1.get(k));
			row1.createCell(1).setCellValue(sh2.get(k));
			row1.createCell(2).setCellValue(sh1actualresult.get(k));
			row1.createCell(3).setCellValue(sh1result.get(k));
			
			FileOutputStream file = new FileOutputStream("C:\\Users\\rajesh.r\\Desktop\\wbbb1.xlsx");
			workbook.write(file);
			file.close();
			System.out.println("Data is copied to Excel Result Sheet 1");
			log.info("Data is copied to Excel Result Sheet 1");
			}
			}
			
			 }
			 catch(Exception e)
			 {
				 System.out.println(e);	 
			 }
			 driver.quit();
			}
		
	public static void readDataFromExcelsheet2() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajesh.r\\Desktop\\chrome\\chromedriver.exe\\");
		  // WebDriver driver = new ChromeDriver();
		// Headless 
		  ChromeOptions options = new ChromeOptions();
	      options.addArguments(new String[] { "--test-type" });
	      options.setHeadless(true); 
	      WebDriver driver = new ChromeDriver(options);
	      
		   sh1result_thread2 = new HashMap<Integer,String>();
		   sh1actualresult_thread2= new HashMap<Integer,String>();
		 try {
		for(int i=1;i<=5;i++) 
		{
			long time=System.currentTimeMillis();
			log.info("Start time of Url from Test data2 s.no: "+i+" "+sh1_thread2.get(1));	
		driver.get(sh1_thread2.get(1));
		System.out.println("getmethodvalue "+sh1_thread2.get(i));
	
		Thread.sleep(2000);
		//getdata.replace("£", "$");
		String	getdata = driver.findElement(By.xpath("//span[@itemprop='price'] | //*[@class='newPrice']")).getText();
		getdata.replace("$", "");
		System.out.println("price is " + getdata );
	
		
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
		
		String getexpprice = sh2_thread2.get(i);
	//
		System.out.println("expected price" + "£"+getexpprice);
	///	Reporter.Reportlog("Done", "expected price" + getexpprice);

//=----covert actual application value to double
		
		String actprice= getdata;
		//double actprice1= Double.parseDouble(getdata1);
		
		//double actprice1= Double.parseDouble(getdata);
//---Convert expected excel value to double
		String expprice= "$"+getexpprice;
		//£,$
		System.out.println("expprice.trim() "+expprice.trim());
		sh1actualresult_thread2.put(i, actprice.trim()); 
		System.out.println("actprice.trim() "+actprice.trim());
		if(actprice.trim().equalsIgnoreCase(expprice.trim()))
		{
			System.out.println("pass double");
			sh1result_thread2.put(i, "pass");
//			setCellData("Pass", i, 3);
		}
		else
		{
			System.out.println("fail double");
			sh1result_thread2.put(i, "fail");
//			setCellData("Fail", i, 3);
//			System.out.println("pass")
		}
		System.out.println("Test data 2 Total  TIme taken in secs: " + i  +" "+(System.currentTimeMillis()-time)/1000);
		log.info("Test data2 total TIme taken in secs: " + i  +" "+(System.currentTimeMillis()-time)/1000);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Result1");

		XSSFRow row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();  
     // Setting Background color  
     style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());  
     style.setFillPattern(FillPatternType.BIG_SPOTS);  
     XSSFCell cell = row.createCell(1);  

		row.createCell(0).setCellValue("URL");
		row.createCell(1).setCellValue("Expected_Value");
		row.createCell(2).setCellValue("Actual_Value");
		row.createCell(3).setCellValue("Status");
				
		for(int j=1;j<=5;j++) {
		XSSFRow row1 = sheet.createRow(j);
		row1.createCell(0).setCellValue(sh1_thread2.get(j));
		row1.createCell(1).setCellValue(sh2_thread2.get(j));
		row1.createCell(2).setCellValue(sh1actualresult_thread2.get(j));
		row1.createCell(3).setCellValue(sh1result_thread2.get(j));
		
		FileOutputStream file = new FileOutputStream("C:\\Users\\rajesh.r\\Desktop\\wbbb2.xlsx");
		workbook.write(file);
		file.close();
		
		System.out.println("Data is copied to Excel Result Sheet 2");
		log.info("Data is copied to Excel Result Sheet 2");
		}
		}
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);	 
		 }
		 driver.quit();
		}		
		public static void setCellDatasheet1(String Result, int RowNum, int ColNum) throws Exception {

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

				FileOutputStream fileOut = new FileOutputStream("C:\\Users\\rajesh.r\\Desktop\\wbb1.xlsx");

				ExcelWBook.write(fileOut);

				fileOut.flush();

				fileOut.close();

			} catch (Exception e) {

				throw (e);

			}

		}
		
		public static void setCellDatasheet2(String Result, int RowNum, int ColNum) throws Exception {

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

				FileOutputStream fileOut = new FileOutputStream("C:\\Users\\rajesh.r\\Desktop\\wbb1.xlsx");

				ExcelWBook.write(fileOut);

				fileOut.flush();

				fileOut.close();

			} catch (Exception e) {

				throw (e);

			}

		}
		
		public static void readexcelsheet1incollection() throws Throwable
		{
			log = Log.getLogger(Log.class);
			
			sh1 = new HashMap<Integer,String>();
			sh2 = new HashMap<Integer,String>();
			setExcelFile("C:\\Users\\rajesh.r\\Desktop\\Parallel execution Files\\17MayGfeedMulti_22.xlsx", "Input1");
		//	driver.navigate().to("getexcelurl");
			for(int i=1;i<=5;i++)
			{
			String getexcelurl1= getCellData(i, 0);
			System.out.println("sheet1"  +i+   getexcelurl1 );	
			String getexpvalue= getCellData(i, 1);
			System.out.println("sheet1"+ getexcelurl1 );
			log.info("Inserting Test data1 urls in collection no "+i +": "+getexcelurl1);
			sh1.put(i, getexcelurl1);
			
			System.out.println("getsh1"  +  sh1.get(i) );
			
		     sh2.put(i, getexpvalue);
			
			System.out.println("getsh2"  +  sh2.get(i) );
			}
			}
			
		
		public static void readexcelsheet2incollection() throws Throwable
		{
			sh1_thread2 = new HashMap<Integer,String>();
			sh2_thread2 = new HashMap<Integer,String>();
			setExcelFile("C:\\Users\\rajesh.r\\Desktop\\Parallel execution Files\\17MayGfeedMulti_22_sheet2.xlsx","Input1");
		//	driver.navigate().to("getexcelurl");
			for(int i=1;i<=5;i++)
			{
			String getexcelurl1= getCellData(i, 0);
			System.out.println("sheet1"  + i+ getexcelurl1 );	
			String getexpvalue= getCellData(i, 1);
			System.out.println("sheet1"+ getexcelurl1 );	
			log.info("Inserting Test data2 urls in collection no "+i +": "+getexcelurl1);
			sh1_thread2.put(i, getexcelurl1);
			
			System.out.println("getsh1_thread2"  +  sh1_thread2.get(i) );
			
		     sh2_thread2.put(i, getexpvalue);
			
			System.out.println("getsh2_thread2"  +  sh2_thread2.get(i) );
			}
			}

}
