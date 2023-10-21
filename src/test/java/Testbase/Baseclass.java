package Testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging


    public class Baseclass 
    {
    	public static WebDriver driver;
	    public Logger logger;//Logger
	    public ResourceBundle rb;//configproperty
	    
	    @BeforeClass(groups= {"Sanity","Regression","Master"})
		@Parameters("browser")   // getting browser parameter from testng.xml
		public void setup(String br)
		{
	      rb=ResourceBundle.getBundle("config");//load config file name
	    	
		  logger =LogManager.getLogger(this.getClass());// logging
		  
		  if (br.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (br.equals("Firefox")) {
				driver = new FirefoxDriver();
			} else {
				driver = new ChromeDriver();
			}
		    
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	   // driver.get("https://letcode.in/signin");
    	    driver.get(rb.getString("appURL"));
    	    driver.manage().window().maximize();
    	
     }
     
    
	@AfterClass(groups= {"Sanity","Regression","Master"})
		public void tearDown()
		{
			driver.quit();
		}
     
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshort\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
     /*public String randomString() 
     {
    	String generatedString= RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
     }
		
	 public String AlphaStringNumerik() 
		     {
		    	String st= RandomStringUtils.randomAlphanumeric(10);
		    	String num= RandomStringUtils.randomNumeric(10);
				return(st+"@"+num);	
		
	         }*/
}
