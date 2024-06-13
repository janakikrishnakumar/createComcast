package practicetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Baseclass.Annotations.Baseclass;


public class InvoiceTest extends Baseclass {

@Test
public void createInvoiceTest() {
	System.out.println("execute createInvoiceTest");
	String actTitle=driver.getTitle();
	Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");

		
}
@Test
public void createInvoicewithph() {
	System.out.println("execute createInvoicewithph");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
	
}

}
