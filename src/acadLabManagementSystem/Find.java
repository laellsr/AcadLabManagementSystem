package acadLabManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Find
{
	static Scanner input = new Scanner( System.in );
	
	public static int sizeType4(ArrayList<Collaborator> collaborators)
	{
		int counter = 0;
		for(int i = 0; i < collaborators.size(); i++)
		{
			if(collaborators.get(i).type == 4)
				counter++;
		}
		return counter;
	}
	
	public static void showType4(ArrayList<Collaborator> collaborators)
	{
		for(int i = 0; i < collaborators.size(); i++)
		{
			if(collaborators.get(i).type == 4)
				System.out.printf("Professor: %s.\n", collaborators.get(i).name);
		}
		System.out.printf("\n");
	}
	
	public static int indexType4(ArrayList<Collaborator> collaborators)
	{
		String name = input.nextLine(); name = name.toUpperCase();
		for(int i = 0; i < collaborators.size(); i++)
		{
			if(collaborators.get(i).name.intern() == name.intern())
				return i;
		}
		System.out.printf("Nome invalido.\n\n");
		return -1;
	}
	
	public static void showResearch(ArrayList<Research> researches)
	{
		for(int i = 0; i < researches.size(); i++)
			System.out.printf("Projeto de Pesquisa: %s.\n Status: %s\n\n", researches.get(i).name, researches.get(i).status);
	}
	
	public static int indexResearch(ArrayList<Research> researches)
	{
		System.out.printf("Digite o titulo do projeto:\n=> ");
		String name = input.nextLine(); name = name.toUpperCase();
		for(int i = 0; i < researches.size(); i++)
		{
			if(researches.get(i).name.intern() == name.intern())
				return i;
		}
		System.out.printf("Nome invalido.\n\n");
		return -1;
	}
	
	public static boolean confirmCollaborator(ArrayList<String> authors, String name)
	{
		for(int i = 0; i < authors.size(); i++)
		{
			if(authors.get(i).intern() == name.intern())
				return true;
		}
		return false;
	}
	public static int indexCollaborator(ArrayList<Collaborator> collaborators, String name)
	{
		for(int i = 0; i < collaborators.size(); i++)
		{
			if(collaborators.get(i).name.intern() == name.intern())
				return i;
		}
		return -1;
	}
	public static void showCollaborator(ArrayList<Collaborator> collaborators)
	{
		for(int i = 0; i < collaborators.size(); i++)
			System.out.printf("%s: %s.\n", collaborators.get(i).typeName, collaborators.get(i).name);
		System.out.printf("\n");
	}
	
}
