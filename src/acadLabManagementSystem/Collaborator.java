package acadLabManagementSystem;

import java.util.Scanner;

public class Collaborator
{
	String name, email;
	int type=0; /* alunos de graduação, alunos de mestrado, alunos de doutorado, professores e pesquisadores */
	String typeName;
	int publishings=0, researches=0, orientations=0;
	
	Scanner input = new Scanner( System.in );
	
	public void setCollaborator()
	{
		setType(); setName(); setEmail();
		System.out.printf("Colaborador adicionado.\n\n");
	}
	public void setName()
	{
		System.out.printf("Digite o nome do colaborador:\n=> ");
		name = input.nextLine();
		name = name.toUpperCase();
	}
	public void setEmail()
	{
		System.out.printf("Digite o email do colaborador:\n=> ");
		email = input.nextLine();
	}
	public void setType()
	{
		System.out.printf("[1] Aluno de graduacao\n"
				+ "[2] Aluno de mestrado\n"
				+ "[3] Aluno de doutorado\n"
				+ "[4] Professor\n"
				+ "[5] Pesquisador\n");
		type = input.nextInt(); input.nextLine();
		switch(type)
		{
			case 1:
				typeName = "Aluno de Graduacao";
				break;
			case 2:
				typeName = "Aluno de Mestrado";
				break;
			case 3:
				typeName = "Aluno de Doutorado";
				break;
			case 4:
				typeName = "Professor";
				break;
			case 5:
				typeName = "Pesquisador";
				break;
		}
	}
	public String getName()
	{
		return name;
	}
}
