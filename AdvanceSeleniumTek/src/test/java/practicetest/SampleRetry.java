package practicetest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleRetry  {
	@Test(retryAnalyzer = listnerUtility.Retryanalyser.class)
	public void activateSim() {
		System.out.println("execute Iretry Analyzer");
		Assert.assertEquals("Login","Login");
		System.out.println("Step-1");
	}

}
