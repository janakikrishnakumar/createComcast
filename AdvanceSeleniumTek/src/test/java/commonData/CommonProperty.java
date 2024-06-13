package commonData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonProperty {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream path= new FileInputStream("‪C:\\Users\\Admin\\OneDrive\\Desktop\\commondata.properties");
		Properties pobj= new Properties();
		pobj.load(path);
		
		System.out.println("url");
	}

}
