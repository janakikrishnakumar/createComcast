package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticePom {

	
public static void main(String[] args) {
	WebDriver driver=new  ChromeDriver();
	driver.get("http://localhost:8888/");
	
	WebElement uname=driver.findElement(By.name("user_name"));
	WebElement pwd=driver.findElement(By.name("user_password"));
	WebElement login= driver.findElement(By.id("submitButton"));
	
	
	uname.sendKeys("admin");
	pwd.sendKeys("admin");
	driver.navigate().refresh();
	
	uname.sendKeys("admin");
	pwd.sendKeys("admin");
	login.click();
	
	
}
}
