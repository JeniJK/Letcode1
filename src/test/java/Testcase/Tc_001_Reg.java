package Testcase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM.Registractionaccount;
import POM.logout;
import Testbase.Baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_001_Reg extends Baseclass
{
	
      
     @Test(groups= {"Sanity","Master"})
   //  @Test(groups= {"Regression","Master"})
     public void testaccountReg() throws InterruptedException
     {
    	 
    	 logger.info("**** Starting Tc_001_Reg ****");
    	 Registractionaccount register=new Registractionaccount(driver);
    	 
    	register.Signlink();
    	logger.info("**** Clicked on Login button ****");
    	
    	 register.setEmail(rb.getString("email"));
    	 logger.info("**** Entered Email ****");
    	
    	 register.setepassword(rb.getString("password"));
    	 logger.info("****  Entered Password ****"); 
    	 
    	 register.Loginbt();
    	 logger.info("**** Continue to Click login button ****"); 
    	 Thread.sleep(10000);
    	 
       logout lg=new logout(driver);
         
         lg.Logout(); 
         logger.info("**** Finally Logout the account ****"); 
         
        
        
    	
         logger.info("**** Finished Tc_001_Reg ****"); 
    	 
     }
      
     
     
    
}
