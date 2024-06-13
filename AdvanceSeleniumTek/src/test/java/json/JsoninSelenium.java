package json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class JsoninSelenium {
	public static void main(String[] args) throws IOException, ParseException,FileNotFoundException {
		
	
	//FileInputStream path=new FileInputStream("‪C:\\Users\\Admin\\OneDrive\\Desktop\\code\\comondata.properties");
	//Properties pobj=new Properties();
		//pobj.load(path);
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./configApp/appdata.json"));
		

	//commonData
	//jsonobject<string> map=(JSONObject)obj;
		JSONObject map=(JSONObject)obj;
	String Browser=(String)map.get("browser");
	String URL=map.get("url").toString();
	String uname=(String)map.get("uname");;
	String pwd=(String)map.get("pwd");
	//generating the data Randomly
	Random ran=new Random();
	int count=ran.nextInt(1000);
	//hardcoding the browser
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
	Sheet sh=wb.getSheet(uname);
	Row row=sh.getRow(1);
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