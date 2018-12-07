package acadLabManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Publishing
{
	ArrayList<String> authors = new ArrayList<String>();
	String name, conference, associated; int year;
	
	Scanner input = new Scanner( System.in );
	
	public void setPublishing()
	{
		System.out.printf("Digite o titulo da publicacao:\n=> ");
		name = input.nextLine();
		System.out.printf("Digite a conferencia onde foi publicada:\n=> ");
		conference = input.nextLine();
		System.out.printf("Projeto associado?\n[1] Sim [2] Nao\n=> ");
		year = input.nextInt(); input.nextLine();
		if (year==1)
		{
			System.out.printf("Digite o projeto associado:\n=> ");
			associated = input.nextLine();
		}
		System.out.printf("Digite o ano da publicacao:\n=> ");
		year = input.nextInt(); input.nextLine();
		System.out.printf("Publicacao adicionada!\n\n");
	}
}
