package pomRules;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DeleteDuplicates {
	WebDriver driver;
	public DeleteDuplicates(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(xpath="//img[@alt='Search in Organizations...']")
	private WebElement searchbtn;
	
	@FindBy(id="bas_searchfield")
	private WebElement indd;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchedt;
	
	@FindBy(name="submit")
	private WebElement search;
	
	@FindBy(partialLinkText = "del")
	private WebElement deletebtn;

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	public WebElement getSearchedt() {
		return searchedt;
	}

	public WebElement getIndd() {
		return indd;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}
	
	public void search(String org_name) {
		searchedt.sendKeys(org_name);
	}
	
	public void dd() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Select sel=new Select(indd);
		sel.selectByIndex(1);
	}
	
	
}
