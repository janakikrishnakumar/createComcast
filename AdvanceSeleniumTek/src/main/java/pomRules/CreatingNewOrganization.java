package pomRules;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingNewOrganization {
public static void main(String[] args) {
	
	//public void createOrgtest(XmlTest test) throws EncryptedDocumentException, IOException {
		//String Browser=test.getParameter("browser");
		//String URL= test.getParameter("Url");
		//String uname=test.getParameter("username");
		//String pwd=test.getParameter("password");
		
		
		/*WebDriver driver=null;
		//if(Browser.equals("Chrome")) {
			//driver=new ChromeDriver();
		//}else if(Browser.equals("Firefox")) {
			/driver=new FirefoxDriver();
		}else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			//driver=new ChromeDriver();
		*/
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		Login l=new Login(driver);
		/*l.getUsernameedt().sendKeys("admin");
		l.getPwdedt().sendKeys("admin");
		l.getLoginbtn().click();*/
		
		l.loginApp("admin", "admin");
Home h=new Home(driver);
h.getOrgLink().click();
OrganizationsPage op=new OrganizationsPage(driver);
op.getOrgnewLink().click();
OrganizationInfo i=new OrganizationInfo(driver);
i.orginfo("ICICI100");
i.getSavebtn().click();
i.getHomebtn().click();


DeleteDuplicates del=new DeleteDuplicates(driver);
del.getSearchbtn().click();
del.search("ICICI10");
del.dd();
del.getSearch().click();
del.getDeletebtn().click();
}
}
