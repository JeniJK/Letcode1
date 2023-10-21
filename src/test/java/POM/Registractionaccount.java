package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.Baseclass;

public class Registractionaccount extends Basepage
{
	 
	    
	  public Registractionaccount(WebDriver driver)
	     {
		    super(driver);
	     }
	   //Elements
	   @FindBy(xpath ="//a[normalize-space()='Log in']")
	    WebElement linkclick;
	     
	   @FindBy(name="email")
	    WebElement email;
		 
	   @FindBy(name="password")
	    WebElement Password;
		 
		 
		 @FindBy(xpath="//button[normalize-space()='LOGIN']")
	     WebElement loginclk;
		 
	    
	     public void Signlink() 
	     {
	    	 linkclick.click();
		}
	     
	     public void setEmail(String mail) 
	     {
	    	email.sendKeys(mail);
		}
		 
		 public void setepassword(String pass) 
	     {
	    	Password.sendKeys(pass);
		}
		 
		
		 public void Loginbt() 
	     {
			 loginclk.click();
	     }
	
	 
}
