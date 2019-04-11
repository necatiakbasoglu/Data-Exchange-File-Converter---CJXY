package products;

public interface IProduct {
	/*
	 * Product interface 
	 * we use jackson library but in jackson library just convert XML,YAML,CSV to 
	 * JSON or wise verse. Beacuse of this reason our product include main function
	 * one : read XML,YAML,CSV or any type and return a JSON string
	 * two : convert file from given JSON string as parameter to needed file type 
	 * you can add new file types later without modification of IProduct but implements.
	 *  
	 * */
	public String getString(String fileSrc);
	public boolean write(String string,String fileSrc);
}
