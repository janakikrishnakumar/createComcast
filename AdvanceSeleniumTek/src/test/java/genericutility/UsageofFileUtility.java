package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericfileutility.Fileutility;

public class UsageofFileUtility {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Fileutility flib=new Fileutility();
		
		String BROWSER=flib.getDatafromPropertyFile("browser");
		String URL=flib.getDatafromPropertyFile("url");
		String UNAME=flib.getDatafromPropertyFile("username");
		String PASS=flib.getDatafromPropertyFile("password");
		WebDriver driver=null;
		if(BROWSER.equals("Chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("Firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.name("user_name")).sendKeys(UNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASS);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		

	}

}
