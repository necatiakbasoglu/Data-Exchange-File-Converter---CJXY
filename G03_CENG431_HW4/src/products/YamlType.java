package products;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.*;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;

public class YamlType implements IProduct{

	@Override
	public String getString(String fileSrc) {
		String returnString = null;
		try {
			String yamlString = ReadFile.readFile(fileSrc);
			
			ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
			Object obj = yamlReader.readValue(yamlString, Object.class);
			ObjectMapper jsonWriter = new ObjectMapper();
			returnString = jsonWriter.writeValueAsString(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!!! PLEASE CHECK FILE PATH");
			System.exit(0);
		}
		return returnString;
	}

	@Override
	public boolean write(String string, String fileSrc) {
		// TODO Auto-generated method stub
		BufferedWriter writer = null ;
		JSONObject json;
		Yaml yaml = new Yaml();
		boolean flag = false;
		try {
			
			JSONArray array = new JSONArray(string);
			String s = "";
			for(int n = 0; n < array.length(); n++)
			{
			    JSONObject object = array.getJSONObject(n);
			    s+=object.toString(2);
			    // do some stuff....
			}
			
			//json = new JSONObject(string);
			@SuppressWarnings("unchecked")
			Map<String,Object> map = (Map<String, Object>) yaml.load(s);
			String outputString = yaml.dump(map);
			if(outputString.substring(0, 3).equals("'-'"))
				outputString = outputString.substring(5, outputString.length());
			writer = new BufferedWriter(new FileWriter(fileSrc));
			writer.write(outputString);
			writer.close();
			flag = true;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}catch (IOException e) {
			// TODO Auto-generated catch block
			flag = false;
		} 
		
		return flag;
	}

}
