package com.Baseclass.Annotations;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genericfileutility.DatabaseUtility;
import genericfileutility.Fileutility;
import pomRules.Login;

public class Baseclass{
	DatabaseUtility db=new DatabaseUtility();
	Fileutility fb=new Fileutility();
	public  WebDriver driver=null;
	public static  WebDriver sdriver=null;
	@BeforeSuite
	public void BeforeSuite() throws SQLException {
		System.out.println("db connected, Report config");
		db.getDbConnection();
	}
@BeforeClass
public void BeforeClass() throws IOException {
	System.out.println("launched browser");
	String BROWSER=fb.getDatafromPropertyFile("browser");
	
	if(BROWSER.equals("Chrome")) {
		driver=new ChromeDriver();
	}else if(BROWSER.equals("Firefox")) {
		driver=new FirefoxDriver();
	}else if(BROWSER.equals("edge")) {
		driver=new EdgeDriver();
	}else {
		driver=new ChromeDriver();
	}
	sdriver=driver;
}
@BeforeMethod
public void BeforeMethod() throws IOException {
	System.out.println("login successfully");
	String URL=fb.getDatafromPropertyFile("url");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			String user=fb.getDatafromPropertyFile("username");
					String pwd=fb.getDatafromPropertyFile("password");
					driver.get(URL);
	Login l=new Login(driver);
	l.loginApp( user, pwd);
	ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
	spark.config().setDocumentTitle("CRM");
	spark.config().setReportName("CRM REPort");
	spark.config().setTheme(Theme.DARK);
	// add env info & create test
	ExtentReports rep=new ExtentReports();
	rep.attachReporter(spark);
	rep.setSystemInfo("OS", "windows-10");
	rep.setSystemInfo("brwser", "Chrome-10");
	
}
@AfterMethod
public void AfterMethod() {
	System.out.println("logout successfully");
	
	
	}
@AfterClass
public void Afterclass() {
	System.out.println("close browser");
	driver.quit();
	

}
@AfterSuite
public void AfterSuite(ExtentReports rep) throws SQLException {
	//ExtentReports rep=new ExtentReports();
	System.out.println("db disconnected");
	db.closeDBConnection();
rep.flush();
	}
}
