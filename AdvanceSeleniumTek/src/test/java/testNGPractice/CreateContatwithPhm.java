package testNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContatwithPhm {
	@Test(dataProvider ="getData")
	public void createContact(String Fn,String ln, String ph) {
		System.out.println("FN"+" "+Fn);
		System.out.println("LN"+" "+ln);
		System.out.println("PH"+" "+ph);
	
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="janaki";
		objArr[0][1]="Krishna";
		objArr[0][2]="9080502080";
		objArr[1][0]="thavanesh"	;	
		objArr[1][1]="Kumar";
		objArr[1][2]="7904283321";
		return objArr;
	}
}
