package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;



public class ReadDatafromdb {

	public static void main(String[] args) throws SQLException {
		// create Project in GUI
		String Project2="Facebook_088";
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://106.51.90.215:8084 ");
		
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		
		driver.findElement(By.partialLinkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		
		driver.findElement(By.name("projectName")).sendKeys(Project2);
		driver.findElement(By.name("createdBy")).sendKeys("rmgyantra");
		
		//WebElement dd=driver.findElement(By.name("status"));
		Select sel= new Select(driver.findElement(By.xpath("(//select[@name='status'])[2]")));
		sel.selectByVisibleText("On Going");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		//verify the project in db(jdbc)
		
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		//Step2: connect to db
		Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		System.out.println("Connected Successfully");
		
		//Step3: Create sql statement
		Statement stat= conn.createStatement();
		
		//Step4:execute select query and give output
		ResultSet set=stat.executeQuery("select * from project");
		boolean flag=false;
		while(set.next()) {
			String actProjectname=set.getString(4);
			if(Project2.equals(actProjectname)) {
				flag=true;
				System.out.println(Project2 + "is available =Pass");
			}
		}
		if(flag==false) {
			System.out.println(Project2 + "is available =Fail");
		
		}
		//Step 5: close the connection
		
	conn.close();
	}

}
