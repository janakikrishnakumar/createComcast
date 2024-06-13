package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Readdatafromxmltestng {
	
	@Test
	public void createOrgtest(XmlTest test) throws EncryptedDocumentException, IOException {
		String Browser=test.getParameter("browser");
		String URL= test.getParameter("Url");
		String uname=test.getParameter("username");
		String pwd=test.getParameter("password");
		
		
		WebDriver driver=null;
		if(Browser.equals("Chrome")) {
			driver=new ChromeDriver();
		}else if(Browser.equals("Firefox")) {
			driver=new FirefoxDriver();
		}else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			driver.findElement(By.name("user_name")).sendKeys(uname);
			driver.findElement(By.name("user_password")).sendKeys(pwd);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
		
		// read TestScript data
		FileInputStream path1=new FileInputStream("‪C:\\Users\\Admin\\OneDrive\\Desktop\\code\\sss.xlsx");
		Workbook wb= WorkbookFactory.create(path1);
		Sheet sh=wb.getSheet("Sheet2");
		Row row=sh.getRow(1);
		//generating the data Randomly
				Random ran=new Random();
				int count=ran.nextInt(1000);

		String Org=row.getCell(2).toString()+count;
		wb.close();
	
		
		//TestScript
		driver.findElement(By.name("accountname")).sendKeys(Org);
	WebElement signout=	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.quit();

}
}