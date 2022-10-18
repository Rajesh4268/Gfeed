package pckg1;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reporter {
	public static List<Result> details;
	private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
	private static final String templatePath = System.getProperty("user.dir")+"\\Screenshots"+"\\report_template.html";
	public static String screenshotpath;
	public static long t1;
	public static long t2;
	public static Logger logger; 
	
	public Reporter() {
	}
	
	public static void initialize() {
		t1 =getCurrentTime();
		System.out.println("t1"+t1);
		details = new ArrayList<Result>();
	}
	
	public static void Reportlog(WebDriver driver,String status,String text ) throws Throwable
	{
		
		//	reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);
		String currentDate1 = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		String currentTime1 = new SimpleDateFormat("hh:mm:ss").format(new Date());
		String repcurrentTime1 = currentTime1.replace(":", "-");

//		String screenshotpath = "//src//Screenshots//Screenshots_"+currentDate1+"_"+repcurrentTime1+".png";
		String dynamicpath = System.getProperty("user.dir");
	//	System.out.println("dynamicpath "+dynamicpath);
		String dynamicpathrep = dynamicpath.replace("\\", "//");
	//	System.out.println("dynamicpathrep "+dynamicpathrep);		
		String screenshotpath = dynamicpathrep.trim()+"//Screenshots//Screenshots_"+currentDate1+"_"+repcurrentTime1+".png";

//		String screenshotpath = System.getProperty("user.dir")+"\\src\\Screenshots\\Screenshots_"+currentDate1+"_"+repcurrentTime1+".png";
		takeSnapShot(driver,screenshotpath);
//		String screenshotpath = prop.getProperty("screenshotpath")+currentDate1+"_"+repcurrentTime1+".png";
//		String screenshotpath = "..//html_report//Newfolder//screenshot"+currentDate1+"_"+repcurrentTime1+".png";
		System.out.println("screenshotpath "+screenshotpath);

		Result r = new Result(status,text,screenshotpath);
		details.add(r);
	}
	
	
	
	
	public static void report(String actualValue,String expectedValue) {
		if(actualValue.equals(expectedValue)) {
			Result r = new Result("Pass","Actual value '" + actualValue + "' matches expected value","");
			details.add(r);
		} else {
			Result r = new Result("Fail","Actual value '" + actualValue + "' does not match expected value '" + expectedValue + "'","");
			details.add(r);
		}
	}
	
	public static void showResults() {
		for (int i = 0;i < details.size();i++) {
			System.out.println("Result " + Integer.toString(i) + ": " + details.get(i).getResult());
		}
	}
	
	public static void writeResults() throws Throwable {
//		loadprofile();
		 t2 =getCurrentTime();
		System.out.println("t2"+t2);
		ExecutionDuration(t2,t1);
		try {
			String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
			for (int i = 0; i < details.size();i++) {
//			//	reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);
//				String currentDate1 = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//				String currentTime1 = new SimpleDateFormat("hh:mm:ss").format(new Date());
//				String repcurrentTime1 = currentTime1.replace(":", "-");
//				
//				String screenshotpath = prop.getProperty("screenshotpath")+currentDate1+"_"+repcurrentTime1+".png";
////				String screenshotpath = "..//html_report//Newfolder//screenshot"+currentDate1+"_"+repcurrentTime1+".png";
//				System.out.println("screenshotpath "+screenshotpath);
////				takeSnapShot(driver,screenshotpath);
////				System.out.println("html "+"<tr><td>" + Integer.toString(i+1) + "<a href='"+screenshotpath+"'>" + details.get(i).getResult()+ "</a></td><td>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);				
////				reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "<a href='"+screenshotpath+"'>" + details.get(i).getResult()+ "</a></td><td>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);
//				System.out.println("html "+"<th width='10%'>" + Integer.toString(i+1)+"</th>" + "<th width='10%'><a href="+screenshotpath+">" + details.get(i).getResult()+ "</a></th>" + "<th width='80%'>"+details.get(i).getResultText() + "</th>" + resultPlaceholder);
		//		JOptionPane.showConfirmDialog(null, details.get(i).getResultScreenshot());
		//		System.out.println("reportdata "+details.get(i).getResultScreenshot());
//				reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><th width='10%'>" + Integer.toString(i+1)+"</th>" + "<th width='10%'><a href="+details.get(i).getResultScreenshot()+">" + details.get(i).getResult()+ "</a></th>" + "<th width='80%'>"+details.get(i).getResultText() + "</th>" + resultPlaceholder);
				reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><th width='10%'>" + Integer.toString(i+1)+"</th>" + "<th width='10%'><a href="+details.get(i).getResultScreenshot()+">" + details.get(i).getResult()+ "</a></th>" + "<th width='80%'>"+details.get(i).getResultText() + "</th>" + resultPlaceholder);
		//	System.out.println("reportIn "+reportIn);
		 	
			}
			String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String currentTime = new SimpleDateFormat("hh:mm:ss").format(new Date());
			String repcurrentTime = currentTime.replace(":", "-");
//			String reportPath = prop.getProperty("reportpath") + currentDate+"_"+repcurrentTime + ".html";
			String reportPath = System.getProperty("user.dir")+"\\ResultsFile\\" + currentDate+"_"+repcurrentTime + ".html";
			
			System.out.println("Result_Report " + reportPath);
	
			
			 
			
			//		JOptionPane.showConfirmDialog(null, "screenshot");
			Files.write(Paths.get(reportPath),reportIn.getBytes(),StandardOpenOption.CREATE);

			
		} catch (Exception e) {
			System.out.println("Error when writing report file:\n" + e.toString());
		}
		
	
	}
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
      //       JOptionPane.showConfirmDialog(null, "takesnapshot");

    }

//	public static void loadprofile() throws Throwable
//	{
//		prop = new Properties();
//	    InputStream input = null;
//
//	        input = new FileInputStream("config.properties");
//
//	        // load a properties file
//	        prop.load(input);
//
//	}

	public static long getCurrentTime()
	{
		long time = System.currentTimeMillis();
		System.out.println(time);
		return time;
	}
	
	public static void ExecutionDuration(long time1,long time)
	{

		long Diff = time1-time;
		System.out.println("Diff "+Diff);
		System.out.println("Diff in sec"+(Diff/1000));
		
	    long millis = Diff;
	    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
	            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
	            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
	    System.out.println("hms format "+hms);
	}

	public static void loginfo(String data)
	{
		logger = Logger.getLogger("Elements");
		PropertyConfigurator.configure("log4j.properties");
		logger.info(data);

	}

	
}