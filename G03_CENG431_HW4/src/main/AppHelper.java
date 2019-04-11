package main;

import java.util.Date;

import factory.Factory;
import helperClasses.FileComparing;
import helperClasses.FileSrcAdjuster;
import helperClasses.FileType;
import log.Log;
import products.IProduct;
import userInterface.ConsoleView;

public class AppHelper {
	private ConsoleView console ;
	private Factory factory;
	private IProduct convertProductFrom;
	private IProduct convertProductTo;
	private FileType typeFrom;
	private FileType typeTo;
	private Log log;
	
	public AppHelper() {
		console = new ConsoleView();
		factory = Factory.getInstance();
		log = Log.getInstance();
		convertProductFrom = factory.createProduct(FileType.JSON);
		convertProductTo = factory.createProduct(FileType.JSON);
	}
	
	
	public void start() {
		int choiceFrom = 0,choiceTo=0;
		while(true){
			choiceFrom = console.getMenuSelectionFromUser("Select the type of file which is convert from");
			typeFrom = selectedType(choiceFrom);
			convertProductFrom = factory.createProduct(typeFrom);
			//selectedHelper(convertProductFrom, typeFrom, choiceFrom);
			String path = console.getFilePathFromUser();
			String jsonString = convertProductFrom.getString(path);
			choiceTo = console.getMenuSelectionFromUser("Select the type of file which is convert to");
			typeTo = selectedType(choiceTo);
			convertProductTo = factory.createProduct(typeTo);
			//selectedHelper(convertProductTo, typeTo, choiceTo);
			String newPath = FileSrcAdjuster.getNewFileName(path, typeTo);
			boolean converting = convertProductTo.write(jsonString, newPath);
			String testString = convertProductTo.getString(newPath);
			System.out.println("----------------TEST STRING-------------\n"+testString);
			System.out.println("----------------JSON STRING-------------\n"+jsonString);	
			boolean testing = FileComparing.compore(jsonString, testString);
			
			if(testing&&converting) {
				console.printToScreen("File is converted successfully and new file at " + newPath);
				log.write(new Date().toString(), typeFrom +" -> " + typeTo, "SUCCESSFUL");
			}
			else {
				log.write(new Date().toString(), typeFrom +" -> " + typeTo, "FAILURE");
				console.printToScreen("File converting FAIL!!!");
				System.out.println(testing+" --- "+converting);
			}
			
		}
	}
	
	private FileType selectedType(int selected) {
		FileType type = null;
		switch (selected) {
		case 1:
			type = FileType.XML;
			break;
		case 2:
			type = FileType.JSON;
			break;
		case 3:
			
			type = FileType.YAML;
			break;
		case 4:
			type = FileType.CSV;
			break;	
		case -1:
			console.printToScreen("Exiting......");
			System.exit(0);
			break;
		}
		return type;
	}
}
