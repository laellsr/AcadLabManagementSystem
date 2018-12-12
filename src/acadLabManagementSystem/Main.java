package acadLabManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		boolean active = true; int mainDecision, index, indexNewC, case3Decision;
		String aux; int auxInt;
		
		ArrayList<Collaborator> collaborators = new ArrayList<Collaborator>();
		ArrayList<Research> researches = new ArrayList<Research>();
		
		Scanner input = new Scanner( System.in );
		
		while(active)
		{
			Menu.mainMenu();
			mainDecision = input.nextInt(); input.nextLine();
			
			switch(mainDecision)
			{
				case 0:
					active = false;
					break;
				case 1:
					Collaborator newCollaborator = new Collaborator();
					newCollaborator.setCollaborator();
					collaborators.add(newCollaborator);
					break;
				case 2:
					if(Find.sizeType4(collaborators)<=0)
					{
						System.out.printf("Sem professores para iniciar um novo projeto.\n\n");
						break;
					}
					Find.showType4(collaborators);
					System.out.printf("Digite o nome do professor para o projeto de pesquisa:\n=> ");
					index = Find.indexType4(collaborators);
					if(index<0)
						break;
					Research newResearch = new Research();
					newResearch.setName();
					newResearch.collaborators.add(collaborators.get(index).getName());
					researches.add(newResearch);
					break;
				case 3:
					Find.showResearch(researches);
					index = Find.indexResearch(researches);
					if(index<0)
						break;
					boolean case3 = active;
					while(case3)
					{
						Menu.researchMenu();
						case3Decision = input.nextInt(); input.nextLine();
						switch(case3Decision)
						{
							case 1:
								if(researches.get(index).status.intern()=="Concluido")
								{
									System.out.printf("Status: Concluido\nNao se pode mais editar.\n\n");
									break;
								}
								if (researches.get(index).status.intern() == "Em andamento")
								{
									System.out.printf("Edicoes ja feitas.\n");
									break;
								}
								researches.get(index).setResearch();
								break;
							case 2:
								if(researches.get(index).status.intern()=="Concluido")
								{
									System.out.printf("Status: Concluido\nNao se pode mais alocar.\n\n");
									break;
								}
								Find.showCollaborator(collaborators);
								System.out.printf("Digite o nome do colaborador:\n=> ");
								aux = input.nextLine(); aux = aux.toUpperCase();
								/* ja eh colaborador? */
								if(Find.confirmCollaborator(researches.get(index).collaborators, aux))
								{
									System.out.printf("Ja faz parte.\n\n");
									break;								
								}
								/* colaborador existe? */
								indexNewC = Find.indexCollaborator(collaborators, aux);
								if(indexNewC<0)
								{
									System.out.printf("Nome invalido:\n\n"); break;
								}
								/* se for aluno de graduacao, passou do limite? */
								if(collaborators.get(indexNewC).researches>=2 && collaborators.get(indexNewC).type==1)
								{
									System.out.printf("Limite de projetos atingido pelo colaborador.\n\n"); break;
								}
								collaborators.get(indexNewC).researches++;
								researches.get(index).collaborators.add(collaborators.get(indexNewC).getName());
								break;
							case 3:
								if(researches.get(index).status.intern()=="Em elaboracao")
								{
									System.out.printf("Status: Em elaboracao\nEdite os dados do projeto.\n\n");
									break;
								}
								if(researches.get(index).status.intern()=="Concluido")
								{
									System.out.printf("Status: Concluido\nNao se pode mais adicionar.\n\n");
									break;
								}
								Find.showCollaborator(collaborators);
								System.out.printf("Digite quantos sao os autores da publicacao:\n=> ");
								auxInt = input.nextInt(); input.nextLine();
								Publishing newPublishing = new Publishing();
								while(auxInt>0)
								{
									System.out.printf("Digite o nome do autor:\n=> ");
									aux = input.nextLine(); aux = aux.toUpperCase();
									newPublishing.authors.add(aux);
									auxInt--;
								}
								newPublishing.setPublishing();
								researches.get(index).publishing.add(newPublishing);
								break;
							case 4:
								if(researches.get(index).status.intern()=="Em elaboracao")
								{
									System.out.printf("Status: Em elaboracao\nEdite os dados do projeto.\n\n");
									break;
								}
								if(researches.get(index).status.intern()=="Concluido")
								{
									System.out.printf("Status: Concluido\nNao se pode mais adicionar.\n\n");
									break;
								}
								System.out.printf("Escolha o orientador:\n");
								Find.showType4(collaborators);
								System.out.printf("=> ");
								indexNewC = Find.indexType4(collaborators);
								if(indexNewC<0)
									break;
								Orientation newOrientation = new Orientation();
								newOrientation.setOrientation(collaborators.get(indexNewC).getName());
								researches.get(index).orientation.add(newOrientation);
								break;
							case 5:
								if(researches.get(index).status.intern()=="Em elaboracao")
								{
									System.out.printf("Status: Em elaboracao\nEdite os dados do projeto.\n\n");
									break;
								}
								else if(researches.get(index).status.intern()=="Concluido")
								{
									System.out.printf("Projeto ja foi concluido.\n\n");
									break;
								}
								if(researches.get(index).publishing.size()>0)
								{
									researches.get(index).status = "Concluido";
									System.out.printf("Status alterado.\n\n");
								}
								else
								{
									System.out.printf("Sem publicacoes para concluir.\n\n");
								}
								
								break;
							case 6:
								case3 = false;
								break;
								
						}
					}
					break;
				case 4:
					Find.showCollaborator(collaborators);
					System.out.printf("Digite o nome do colaborador:\n=> ");
					aux = input.nextLine(); aux = aux.toUpperCase();
					/* colaborador existe? */
					index = Find.indexCollaborator(collaborators, aux);
					if(index<0)
					{
						System.out.printf("Nome invalido:\n\n"); break;
					}
					Find.showPerfil(index, collaborators, researches);
					break;
				case 5:
					Find.showResearch(researches);
					index = Find.indexResearch(researches);
					if(index<0)
						break;
					break;
				case 7:
					active = false;
					break;
			}
		}
		
		input.close();
	}

}
