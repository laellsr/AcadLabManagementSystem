package acadLabManagementSystem;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Research
{
	String name, fundingAgency, dateAux; 
	Date initialDate, finalDate; 
	String objective = "vazio", description;
	String status = "Em elaboracao";
	ArrayList<String> collaborators = new ArrayList<String>();
	double financedAmount;

	ArrayList<Publishing> publishing = new ArrayList<Publishing>();
	ArrayList<Orientation> orientation = new ArrayList<Orientation>();
	
	Scanner input = new Scanner( System.in );
	
	public void setResearch()
	{
		setDate(); setPerfil(); status = "Em andamento";
		System.out.printf("Informacoes editadas.\nNovo status: Em andamento.\n\n");
		
	}
	public void setName()
	{
		System.out.printf("Digite um titulo:\n=> ");
		name = input.nextLine();
		name = name.toUpperCase();
		System.out.printf("Projeto adicionado.\nEdite as informacoes!\n\n");
	}
	public void setDate()
	{
		System.out.printf("Digite a data de inicio (DD/MM/AAAA):\n=> ");
		dateAux = input.nextLine();
		try {
			initialDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateAux);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Digite a data de termino (DD/MM/AAAA):\n=> ");
		dateAux = input.nextLine();
		try {
			finalDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateAux);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setPerfil()
	{
		System.out.printf("Digite o objetivo da pesquisa:\n=> ");
		objective = input.nextLine();
		System.out.printf("Digite uma descricao da pesquisa:\n=> ");
		description = input.nextLine();
		System.out.printf("Digite o nome da agencia financioadora:\n=> ");
		fundingAgency = input.nextLine();
		System.out.printf("Digite o valor do financiamento (Ex.: 999,99):\n=> R$ ");
		financedAmount = input.nextDouble(); input.nextLine();
	}

}
