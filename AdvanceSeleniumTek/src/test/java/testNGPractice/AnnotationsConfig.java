package testNGPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsConfig {
@BeforeSuite
public void BS(){
	System.out.println("BS Executed");
}
@AfterSuite
public void AS() {
	System.out.println("ASuite executed");
}
@org.testng.annotations.BeforeClass
public void BC() {
	System.out.println("BC executed");
}

	
	
	@BeforeMethod
public void BM() {
	System.out.println("BM executed");
}	
	@Test

public void contat() {
	System.out.println("Contact created");
}
	@AfterMethod
	public void AM() {
		System.out.println("AM executed");
	}
	@AfterClass
	public void AC() {
		System.out.println("AC executed");
	}
}
