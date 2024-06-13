package objectRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public  class LoginPOM {
	WebDriver driver;
	public  LoginPOM(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement uname;
	
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	

	public WebElement getUname() {
		return uname;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}




	@Test
	public void LoginApp(String url, String username,String pwd) {
		//WebDriver driver=new  ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	uname.sendKeys(username);	
	password.sendKeys(pwd);
	loginbtn.click();
	
		
	
	

}
}
