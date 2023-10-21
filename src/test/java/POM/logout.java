package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class logout extends Basepage
{  
	
	public logout(WebDriver driver)
    {
	    super(driver);
    }

	//Elements
	   @FindBy(xpath ="//a[normalize-space()='Sign out']")
	    WebElement click1;
	   
	   public void Logout() 
	     {
		   click1.click();
	     }
}
