package screenshot;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Samplescreen {
	@Test
	public void screenTest() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://amazon.in");
		TakesScreenshot edriver=(TakesScreenshot)driver;
		File ss=edriver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("./screenshot/test.png"));
		driver.quit();
		
		
	}

}
