package br.com.fiap.classeSingleton;

import java.util.Locale;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		DAOImplement dao = new DAOImplement();
		
	    Produto produto = new Produto();
	    
		boolean x;
		int escolha;
		
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.ENGLISH);

		do {
			System.out.println("\nEscolha conforme o menu:");
			System.out.println("1. INSERT");
			System.out.println("2. DELETE");
			System.out.println("3. UPDATE");
			System.out.println("4. SELECT");
			
			escolha = input.nextInt();
			
			input.nextLine();
			
			switch (escolha) {
				case 1:
					System.out.println("\nInsira o nome do produto: ");
					produto.setNome(input.nextLine());
					
					java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
					produto.setDataValidade(data);
				
					System.out.println("\nInsira o preço do produto (R$): ");
					produto.setValor(input.nextDouble());
					
					dao.gravar(produto);
				break;
					
				default:
					System.out.println("\nEscolha inválida!");
			}
			
			System.out.println("\nDeseja continuar? Digite true para SIM ou false para NÃO");
			
			x = input.nextBoolean();
			input.nextLine();
			
		} while (x == true);
		
		input.close();
	}

}
