package testNGPractice;

import org.testng.annotations.Test;

public class OrderTest {
@SuppressWarnings("null")
@Test
public void createOrderTest() {
	System.out.println("Execute create OrderTest==> 123");
	String s=null;
	System.out.println(s.equals("123"));
}
@Test(dependsOnMethods = "createOrderTest")
public void billingAnOrderTest() {
	System.out.println("Execute BillingAnOrderTest==>123");
}
}
