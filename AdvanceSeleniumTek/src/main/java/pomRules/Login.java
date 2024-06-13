package pomRules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(name="user_name")
private WebElement usernameedt;

@FindBy(name="user_password")
private WebElement pwdedt;

@FindBy(id="submitButton")
private WebElement loginbtn;

// object Initalization in main class(CreatingNewOrganization)
//4.. Provide getter Encapsulation
public WebElement getUsernameedt() {
	return usernameedt;
}

public WebElement getPwdedt() {
	return pwdedt;
}

public WebElement getLoginbtn() {
	return loginbtn;
}

// providing Business method

public void loginApp(String username,String password) {
usernameedt.sendKeys(username);
pwdedt.sendKeys(password);
loginbtn.click();
}

}
