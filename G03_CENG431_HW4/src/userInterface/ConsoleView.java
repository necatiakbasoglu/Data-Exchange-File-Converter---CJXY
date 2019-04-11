package userInterface;

import java.util.Scanner;

public class ConsoleView {
	private Scanner inputFromUser = null;
	
	public ConsoleView() {
		inputFromUser = new Scanner(System.in);
	}
	
	public int getMenuSelectionFromUser(String fromOrTo) {
		System.out.println(fromOrTo);
		System.out.println("1: XML");
		System.out.println("2: JSON");
		System.out.println("3: YAML");
		System.out.println("4: CSV");
		System.out.println("-1: EXIT");
		int selection  = inputFromUser.nextInt();
		inputFromUser.nextLine();
		return selection;
	}
	
	public String getFilePathFromUser() {
		System.out.println("Enter File Path: ");
		return inputFromUser.nextLine();
		
	}
	
	public void printToScreen(String message) {
		System.out.println(message);
	}
	
}
