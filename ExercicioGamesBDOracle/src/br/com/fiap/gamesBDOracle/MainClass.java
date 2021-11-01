package br.com.fiap.gamesBDOracle;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		boolean x;
		int escolha, vendas;
		String cnpj, nome, esporte, sistema;
		
		DataInsert dataInsert = new DataInsert();
		DataUpdate dataUpdate = new DataUpdate();
		DataSelect dataSelect = new DataSelect();
		DataDelete dataDelete = new DataDelete();
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("Escolha conforme o menu:");
			System.out.println("1. INSERT");
			System.out.println("2. DELETE");
			System.out.println("3. UPDATE");
			System.out.println("4. SELECT");
			
			escolha = entrada.nextInt();
			
			entrada.nextLine();
			
			switch(escolha) {
				case 1:
					System.out.println("CNPJ: ");
					cnpj = entrada.nextLine();
					
					System.out.println("Nome: ");
					nome = entrada.nextLine();
					
					System.out.println("Esporte: ");
					esporte = entrada.nextLine();
					
					System.out.println("Vendas: ");
					vendas = entrada.nextInt();
					
					entrada.nextLine();

					System.out.println("Sistema: ");
					sistema = entrada.nextLine();

					dataInsert.doInsert(cnpj, nome, esporte, vendas, sistema);
				break;
				
				case 2:
					System.out.println("CNPJ: ");
					cnpj = entrada.nextLine();
					
					dataDelete.doDelete(cnpj);
				break;
				
				case 3:
					System.out.println("Vendas: ");
					vendas = entrada.nextInt();					
					entrada.nextLine();

					System.out.println("CNPJ: ");
					cnpj = entrada.nextLine();
					
					dataUpdate.doUpdate(vendas, cnpj);
				break;
				
				case 4:
					System.out.println("CNPJ: ");
					cnpj = entrada.nextLine();
					
					dataSelect.doSelect(cnpj);
				break;
				
				default:
					System.out.println("Escolha inválida!");
			}
			
			System.out.println("Deseja continuar? Digite true se SIM ou false se NÃO");
			x = entrada.nextBoolean();
			
			entrada.nextLine();
			
		} while(x == true);
		
		entrada.close();
	}

}
