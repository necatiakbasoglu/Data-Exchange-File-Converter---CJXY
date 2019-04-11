package helperClasses;

import org.codehaus.jackson.map.ObjectMapper;

public class FileComparing {
	/*
	 * 
	 * takes two JSON string then send them into a tree
	 * then compare two tree
	 * Example: 
	 * XML to YAML
	 * 
	 * first convert XML to JSON string then this JSON string(1) 
	 * to YAML. At last we convert YAML to JSON string(2) then compare two 
	 * JSON string(1) and JSON string(2) whether conversion is successful or not 
	 */
	
	public static boolean compore(String obj1,String obj2) {
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("NECATI-------------------"+obj1 +"\n"+ obj2 );
		org.codehaus.jackson.JsonNode tree1 = null;
		org.codehaus.jackson.JsonNode tree2 = null;
		try {
			tree1 = mapper.readTree(obj1);
			tree2 = mapper.readTree(obj2);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return tree1.equals(tree2);
	}
}
