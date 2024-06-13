package advancedReprt;

import org.testng.annotations.Test;

import com.Baseclass.Annotations.Baseclass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class SampleReport extends Baseclass {
	public  ExtentReports rep;
	public ExtentTest log1;
	@Test

public void basicTest() {
	// spark Report Configuration
	
	ExtentTest log1= rep.createTest("basicTest");
	log1.log(Status.INFO,"login to App");
	log1.log(Status.INFO, "navogate to contact");
log1.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC")) {
	
		log1.log(Status.PASS, "Contact is created");
	}else {
		log1.log(Status.FAIL, "Contact is not created");
	}
	log1.log(Status.INFO,"login to App");

}
}
