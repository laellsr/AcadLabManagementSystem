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
	public static void showPerfil(int index, ArrayList<Collaborator> collaborators, ArrayList<Research> researches)
	{
		System.out.printf("%s: %s.\nE-mail: %s\n", collaborators.get(index).typeName, collaborators.get(index).name, collaborators.get(index).email);
		
		for(int j = 0; j < researches.size(); j++)
			for(int i = 0; i < researches.get(j).collaborators.size(); i++)
			{
				if(collaborators.get(index).name.intern() == researches.get(j).collaborators.get(i).intern())
				{
					System.out.printf("Proj. de Pesquisa: %s.\nDescricao: %s.\nStatus: %s.\n", researches.get(j).name, researches.get(j).description,researches.get(j).status);
					for(int k=0; k < researches.get(j).publishing.size(); k++)
						for(int l=0; l < researches.get(j).publishing.get(k).authors.size(); l++)
							if(collaborators.get(index).name.intern() == researches.get(j).publishing.get(k).authors.get(l).intern())
							{
								System.out.printf("Publicacao: %s.\nAno: %s.\n"
										+ "Conferencia: %s.\nAssociacao: %s.\n\n", researches.get(j).publishing.get(k).name,
										researches.get(j).publishing.get(k).year, researches.get(j).publishing.get(k).conference, researches.get(j).publishing.get(k).associated);
							}
				}
				
			}
		
		System.out.printf("\n");
	}
	public static void showProject(Research research)
	{
		System.out.printf("Proj. de Pesquisa: %s.\nDescricao: %s.\nStatus: %s.\n",
				research.name, research.description,research.status);
		for(int i=0; i < research.collaborators.size(); i++)
			System.out.printf("Colaborador: %s.\n", research.collaborators.get(i));
		for(int i=0; i < research.publishing.size(); i++)
			System.out.printf("Publicacao: %s.\nAno: %s.\n"
					+ "Conferencia: %s.\nAssociacao: %s.\n\n", research.publishing.get(i).name,
					research.publishing.get(i).year, research.publishing.get(i).conference, research.publishing.get(i).associated);
			
		System.out.printf("\n");
	}
	public static void showSystem(ArrayList<Collaborator> collaborators, ArrayList<Research> researches)
	{
		int p1 = 0, p2 = 0, p3 = 0, max=0;
		for(int i =0; i < researches.size(); i++)
		{
			if (researches.get(i).status.intern() == "Em elaboracao")
				p1++;
			else if (researches.get(i).status.intern() == "Em andamento")
				p2++;
			else if (researches.get(i).status.intern() == "Concluido")
				p3++;
			if (researches.get(i).publishing.size()>max)
				max = researches.get(i).publishing.size();
		}
		System.out.printf("Relatorio de Producao Academica do Laboratotio\n");
		System.out.printf("=> %s colaboradores\n"
				+ "=> %s projetos em elaboracao\n"
				+ "=> %s projetos em andamento\n"
				+ "=> %s projetos concluidos\n"
				+ "=> %s projetos no total\n"
				+ "=> %s numero maximo de produçao academica por tipo de producao\n\n",
				collaborators.size(), p1, p2, p3, p1+p2+p3, max);
	}
	
}
