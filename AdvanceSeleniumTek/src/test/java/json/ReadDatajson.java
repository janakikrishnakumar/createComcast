package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDatajson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		
		//Parse the json to java object
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("‪C:\\Users\\Admin\\OneDrive\\Desktop\\code\\appdata.json"));
		
		//convert object to Json
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("url"));
		

	}

}
