package helperClasses;

public class FileSrcAdjuster {
	/*
	 * this class responsible for converting given filename to needed type  
	 * example: assume client wants to convert json to xml
	 * C:\test.json -> C:\test.xml 
	 */
	public static String getNewFileName(String fileSrc , FileType type) {
		String newFileName = fileSrc.substring(0, fileSrc.lastIndexOf("."));
		newFileName = newFileName+"(kopya)."+ type.toString().toLowerCase();
		return newFileName;
	}
}
