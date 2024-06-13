package objectRepo;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class Dummy {

	static WebDriver driver = null;

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./configapp/comondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);

		// commonData
		String Browser = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String uname = pobj.getProperty("username");
		String pwd = pobj.getProperty("password");
		// hardcoding the browser

		if (Browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys(uname);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// generating the data Randomly
		Random ran = new Random();
		int count = ran.nextInt(1000);

		// read TestScript data
		FileInputStream fis1=new FileInputStream("./configapp/sss.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet2");
		Row row = sh.getRow(1);
		String Org = row.getCell(2).toString() + count;
		wb.close();

		// TestScript
		driver.findElement(By.name("accountname")).sendKeys(Org);
		WebElement signout = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));

		Actions act = new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.quit();

	}
}
