package testNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactdataprovider {
	
	@Test(dataProvider = "getData")
	public void createContact(String firstname,String LastName) {
		System.out.println("FN"+" "+firstname);
		System.out.println("LN"+" "+LastName);
	}
	
@DataProvider
public Object[][] getData() {
	Object[][] objArr=new Object[3][2];
	objArr[0][0]="Janaki";
	objArr[0][1]="Krishna"	;	
	objArr[1][0]="thavanesh";
	objArr[1][1]="Kumar";
	return objArr;
}
}
