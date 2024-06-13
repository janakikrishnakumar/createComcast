package genericfileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutility {
	public String getDatafromPropertyFile(String Key) throws IOException {
		FileInputStream fis=new FileInputStream("./configapp/comondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(Key);
		
		return data;
	}

}
