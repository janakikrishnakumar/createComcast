package genericutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JasonUtility {
	
	public String getDatafromJsonFile(String Key) throws IOException, ParseException {
		FileReader fileR=new FileReader("./configapp/appdata.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fileR);
		JSONObject map= (JSONObject) obj;
		String data=(String) map.get(Key);
		return data;
		
		
	}

}
