package products;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;


public class CsvType implements IProduct {
	
	@Override
	public String getString(String fileSrc) {
		String returnString = null;
		try {
			String csvString = ReadFile.readFile(fileSrc);
			JSONArray array = CDL.toJSONArray(csvString);
			returnString = array.toString(2);
			if(returnString.substring(0, 2).equals("[{"))
				returnString = returnString.substring(1,returnString.length()-1);
			System.out.println(returnString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found!!! PLEASE CHECK FILE PATH");
			System.exit(0);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnString;
	}

	@Override
	public boolean write(String string, String fileSrc) {
		// TODO Auto-generated method stub
		BufferedWriter writer = null ;
		JSONArray arrayx;
		
		boolean flag =false;
		try {
			if(string.substring(0, 5).equals("{\"-\":"))
				string = string.substring(5,string.length()-1);
			else if(string.charAt(0)!='[')
				string = "["+string+"]";
			arrayx = new JSONArray(string);
			String csv = CDL.toString(arrayx);
			//System.out.println(csv);
			writer = new BufferedWriter(new FileWriter(fileSrc));
            writer.write(csv);
			writer.close();
			
			flag = true;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag =  false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
