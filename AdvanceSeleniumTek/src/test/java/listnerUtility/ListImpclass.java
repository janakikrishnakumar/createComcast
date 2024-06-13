package listnerUtility;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Baseclass.Annotations.Baseclass;

public class ListImpclass implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report Confi");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("===>"+result.getMethod().getMethodName()+"====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("this test is ended");	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String test=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)Baseclass.sdriver;
		File ss= ts.getScreenshotAs(OutputType.FILE);

		String time=new Date().toString().replace(" ","_").replace(":","_");
		try {
			FileUtils.copyFile(ss, new File("./screenshot/"+test+ "+"+time +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}

	
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	
	

}
