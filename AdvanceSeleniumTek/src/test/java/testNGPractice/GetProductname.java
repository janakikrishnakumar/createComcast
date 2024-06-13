package testNGPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductname {

	@Test(dataProvider ="getData" )
	public void getProductInfo(String brand,String Product) {
		WebDriver driver= new ChromeDriver();
		driver.get("https:/www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brand,Keys.ENTER);
		String x="//span[text()='"+Product+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/a/span/span[2]/span[2]";	
		//capture product info
		String r=driver.findElement(By.xpath(x)).getText();
		System.out.println(r);
		driver.close();
		
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="iphone";
		objArr[0][1]="Apple iPhone 13 (128GB) - Blue";
		
		objArr[1][0]="iphone";
		objArr[1][1]="Apple iPhone 13 (128GB) - Midnight";
		
		objArr[2][0]="iphone";
		objArr[2][1]="Apple iPhone 13 (128GB) - Starlight";
		return objArr;
	}

	
}

