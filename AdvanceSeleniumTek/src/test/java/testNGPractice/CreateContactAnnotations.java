package testNGPractice;

import org.testng.annotations.Test;

import com.Baseclass.Annotations.Baseclass;

public class CreateContactAnnotations extends Baseclass {
@Test
public void createContact() {
	System.out.println("execute createContact");
}

@Test
public void createContactwithDate() {
	System.out.println("execute createContactwithDate");
}
}
