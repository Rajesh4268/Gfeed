package demo;
    import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

    import org.json.JSONException;
    import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.logging.LogEntries;
    import org.openqa.selenium.logging.LogEntry;
    import org.openqa.selenium.logging.LogType;
    import org.openqa.selenium.logging.LoggingPreferences;
    import org.openqa.selenium.remote.CapabilityType;
    import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

    public class TestResponseCode
    {
        public static void main(String[] args) throws InterruptedException
        {
//            // simple page (without many resources so that the output is
//            // easy to understand
//            String url = "https://www.bannerbuzz.com/mens-raglan-t-shirt-long-sleeves/p";
//
//            DownloadPage(url);
        	
//        	DesiredCapabilities d = DesiredCapabilities.chrome();
//        	LoggingPreferences logPrefs = new LoggingPreferences();
//        	logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
//        	d.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//        	WebDriver driver = new ChromeDriver(d);
//        	driver.get("https://www.google.co.in/");
//        	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        	LogEntries les = driver.manage().logs().get(LogType.PERFORMANCE);
//        	for (LogEntry le : les) {
//        	    System.out.println(le.getMessage());
//        	}        	
       	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajesh.r\\Desktop\\chrome\\chromedriver.exe\\");        	
       	ChromeOptions options = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable( LogType.PERFORMANCE, Level.FINE );
        options.setCapability( "goog:loggingPrefs", logPrefs );
        	WebDriver driver = new ChromeDriver(options);
        	driver.get("https://www.bannerbuzz.com/mens-raglan-t-shirt-long-sleeves/p");
        	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        	
        	driver.findElement(By.xpath("//*[text()='Add To Cart']")).click();
        	Thread.sleep(7000);
        	
        	
        	
        	LogEntries les = driver.manage().logs().get(LogType.PERFORMANCE);
        	for (LogEntry le : les) {
        	    System.out.println(le.getMessage());
        	}
        }

        private static void DownloadPage(String url)
        {
        	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajesh.r\\Desktop\\chrome\\chromedriver.exe\\");
        	 //  WebDriver driver = new ChromeDriver();
            ChromeDriver driver = null;
//            WebDriver driver = new ChromeDriver();
//			 driver.manage().window().maximize();

            try
            {
                ChromeOptions options = new ChromeOptions();
                // add whatever extensions you need
                // for example I needed one of adding proxy, and one for blocking
                // images
                // options.addExtensions(new File&#40;file, "proxy.zip"&#41;);
                // options.addExtensions(new File&#40;"extensions",
                // "Block-image_v1.1.crx"&#41;);

              
                
                
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setCapability(ChromeOptions.CAPABILITY, options);

//                // set performance logger
//                // this sends Network.enable to chromedriver
//                LoggingPreferences logPrefs = new LoggingPreferences();
//                logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
//                cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable( LogType.PERFORMANCE, Level.ALL );
                options.setCapability( "goog:loggingPrefs", logPrefs );

                driver = new ChromeDriver(cap);

                // navigate to the page
                System.out.println("Navigate to " + url);
                driver.navigate().to(url);

                // and capture the last recorded url (it may be a redirect, or the
                // original url)
                String currentURL = driver.getCurrentUrl();

                // then ask for all the performance logs from this request
                // one of them will contain the Network.responseReceived method
                // and we shall find the "last recorded url" response
                LogEntries logs = driver.manage().logs().get("performance");

                int status = -1;

                System.out.println("\nList of log entries:\n");

                for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();)
                {
                    LogEntry entry = it.next();

                    try
                    {
                        JSONObject json = new JSONObject(entry.getMessage());

                        System.out.println(json.toString());

                        JSONObject message = json.getJSONObject("message");
                        String method = message.getString("method");

                        if (method != null
                                && "Network.responseReceived".equals(method))
                        {
                            JSONObject params = message.getJSONObject("params");

                            JSONObject response = params.getJSONObject("response");
                            String messageUrl = response.getString("url");

                            if (currentURL.equals(messageUrl))
                            {
                                status = response.getInt("status");

                                System.out.println(
                                        "---------- returned response for "
                                                + messageUrl + ": " + status);

                                System.out.println(
                                        "---------- headers: "
                                                + response.get("headers"));
                            }
                        }
                    } catch (JSONException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                System.out.println("\nstatus code: " + status);
            } finally
            {
                if (driver != null)
                {
                    driver.quit();
                }
            }}}
        