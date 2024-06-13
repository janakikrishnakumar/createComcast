package testng;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDatafromtestngTest {
@Test
	public void sampleTest(XmlTest test) {
		System.out.println("sample Test");
		System.out.println(test.getParameter("browser"));
		System.out.println(test.getParameter("Url"));
		System.out.println(test.getParameter("username"));
		System.out.println(test.getParameter("password"));
	}
	

}
