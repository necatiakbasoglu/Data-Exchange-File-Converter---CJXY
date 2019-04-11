package products;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonType implements IProduct {

	@Override
	public String getString(String fileSrc) {
		String returnString = null;
		try {
			String jsonString = ReadFile.readFile(fileSrc);
			/*
			if(jsonString.charAt(0)=='[')
				jsonString = "{'-':"+jsonString+"}";
			JSONObject jsonObj = new JSONObject(jsonString);
			*/
			
			ObjectMapper jsonReader = new ObjectMapper(new JsonFactory());
			Object obj = jsonReader.readValue(jsonString, Object.class);
			ObjectMapper jsonWriter = new ObjectMapper();
			returnString = jsonWriter.writeValueAsString(obj);
			
			//returnString = jsonObj.toString(4);
			
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
		
		
		boolean flag = false;
		try {
			//json = new JSONObject();
			
			
			writer = new BufferedWriter(new FileWriter(fileSrc));
            writer.write(string);
			writer.close();
			flag = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		} 
		return flag;
	}
}
