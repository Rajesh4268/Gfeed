package demo;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {
	public static String actualdata;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajesh.r\\Desktop\\chrome\\chromedriver.exe\\");
		   WebDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, 20);
		   driver.manage().window().maximize();
		   driver.get("https://www.autoparts4less.com/parts-accessories");
		   
		List<WebElement> imgdata = driver.findElements(By.xpath("//div[@class='card-img']"));	
       	System.out.println("test "+imgdata.size());	
       
       	Thread.sleep(5000);
       	for(int k =1;k<=imgdata.size();k++)
       	{
       		Thread.sleep(5000);
       	//	int k1 = k%2;
       		
       		System.out.println("K1 "+k);
       		WebElement tempicon = driver.findElement(By.xpath("(//div[@class='card-img'])["+k+"]"));
       		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='card-img']")));
    	//	clickjavascriptelement(driver, tempicon);
       		tempicon.click();
       		//JOptionPane.showConfirmDialog(null, null);
       		Thread.sleep(6000);
       		driver.navigate().back();
    		//actualdata =tempicon.getAttribute("src");
    	//	System.out.println("actualdata "+actualdata);
       	
       	}
       	
       	}
       	public static void clickjavascriptelement(WebDriver driver, WebElement element){

    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", element);
    		
    		}     	
}
