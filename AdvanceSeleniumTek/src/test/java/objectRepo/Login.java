package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Login {
	
	@FindBy(name="user_name")
	WebElement ele1;
	
	
	@FindBy(name="user_password")
	WebElement ele2;
	
	@FindBy(id="submitButton")
	WebElement ele3;
		
	
	@Test
	public void sampleTest() {
		WebDriver driver=new  ChromeDriver();
		driver.get("http://localhost:8888/");
		
		Login w=PageFactory.initElements(driver,Login.class);
	
	w.ele1.sendKeys("admin");
	w.ele2.sendKeys("admin");
	driver.navigate().refresh();
	
	w.ele1.sendKeys("admin"); 
	w.ele2.sendKeys("admin");
	w.ele3.click();
	

}
}