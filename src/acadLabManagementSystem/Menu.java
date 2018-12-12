package acadLabManagementSystem;

public class Menu
{
	public static void nextPass()
	{
		System.out.printf("[1] Continue\n");
	}
	public static void mainMenu()
	{
		System.out.printf(
				"Sistema de Gestao de Produtividade Academica\n\n"
				+ "[1] Adicionar colaborador ao sistema\n"
				+ "[2] Novo projeto de pesquisa\n"
				+ "[3] Editar projeto de pesquisa\n"
				+ "[4] Consulta por colaborador\n"
				+ "[5] Consulta por projeto\n"
				+ "[6] Relatorio do Laboratorio\n"
				+ "[7] Sair\n\n=> ");
	}
	public static void researchMenu()
	{
		System.out.printf(
				"[1] Editar informacoes\n"
				+ "[2] Alocar colaborador\n"
				+ "[3] Publicar no projeto\n"
				+ "[4] Orientar no projeto\n"
				+ "[5] Concluir um projeto\n"
				+ "[6] Voltar\n=> ");
	}
}
