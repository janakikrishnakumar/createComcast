package testNGPractice;

import org.testng.annotations.Test;

public class ContactTest {

	@Test(priority=1)
	public void createContactTest() {
		System.out.println("Contact created ");
	}
	
	@Test(priority=0)
	public void modifyContact() {
		System.out.println("Modified");
	}
	
	@Test(priority=2)
	public void deletecontact() {
		System.out.println("Delted Contact");
	}
}
