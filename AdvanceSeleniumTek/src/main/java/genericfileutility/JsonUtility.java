package genericfileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDatafromJson(String Key) throws IOException, ParseException {
		FileReader fr=new FileReader("./configapp/appdata.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fr);
		
		//convert object to Json
		JSONObject map=(JSONObject)obj;
		String data=(String) map.get(Key);
		return data;
				
		
		
	}

}
