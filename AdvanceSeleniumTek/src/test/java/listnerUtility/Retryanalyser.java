package listnerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryanalyser implements IRetryAnalyzer {
 int count=0;
 int limit_count=5;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<limit_count) {
			count++;
			return true;
		}else {
		return false;
	}
	

}
	}
