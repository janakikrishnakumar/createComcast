package pomRules;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	WebDriver driver;
	public OrganizationInfo(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	
	@FindBy(xpath ="//input[@name='accountname']")
	private WebElement orgedt;
	
	@FindBy(xpath="(//input[@accesskey='S'])[1]")
	private WebElement savebtn;
	
	@FindBy(xpath="//img[@style='width:16px;height:16px;']")
	private WebElement homebtn;
	 
	
	public WebElement getOrgedt() {
		return orgedt;
	}
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public void orginfo(String orgname) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		orgedt.sendKeys(orgname);
		
	}

	public WebElement getHomebtn() {
		return homebtn;
	}


	
}
