package products;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class XmlType implements IProduct {
	
	@Override
	public String getString(String fileSrc) {
		// TODO Auto-generated method stub
		
		String returnString = null;
		try {
			String xmlString = ReadFile.readFile(fileSrc);
			ObjectMapper xmlReader = new ObjectMapper(new XmlFactory());
			Object obj = xmlReader.readValue(xmlString, Object.class);
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
	public boolean write(String string,String fileSrc) {
		// TODO Auto-generated method stub
		BufferedWriter writer = null ;
		
		String xml;
		boolean flag = false;
		
		try {
			//json = new JSONObject(string);
			ObjectMapper jsonReader = new ObjectMapper(new JsonFactory());
			Object obj = jsonReader.readValue(string, Object.class);
			XmlMapper xmlMapper = new XmlMapper();
			xml = xmlMapper.writeValueAsString(obj);
			writer = new BufferedWriter(new FileWriter(fileSrc));
            writer.write(xml);
			writer.close();
			flag = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			flag = false;
		} 
		return flag;
		
	}

}
