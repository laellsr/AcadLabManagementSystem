package acadLabManagementSystem;

import java.util.Scanner;

public class Orientation
{
	String text, author;
	static Scanner input = new Scanner( System.in );
	
	public void setOrientation(String author)
	{
		this.author = author;
		System.out.printf("Digite a orientacao:\n=> ");
		text = input.nextLine();
		System.out.printf("Orientacao adicionado ao projeto.\n\n");
	}
}
