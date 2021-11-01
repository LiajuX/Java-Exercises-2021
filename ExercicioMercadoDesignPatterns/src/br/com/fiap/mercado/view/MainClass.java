package br.com.fiap.mercado.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.mercado.dao.DAOFactory;
import br.com.fiap.mercado.dao.ProdutoDAO;
import br.com.fiap.mercado.entity.Produto;


public class MainClass {
	
	public static void main(String[] args) {
		ProdutoDAO dao = DAOFactory.getProdutoDAO();
		
        Produto produto = new Produto();
        
        boolean continuaLoop;
        int opcao, codigo;
        Double valor;
        String nome;
        Calendar calendar = new GregorianCalendar(2021, 11, 01);

        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("\nEscolha conforme menu:");
            System.out.println("1. INSERT");            
            System.out.println("2. DELETE");           
            System.out.println("3. UPDATE"); 
            System.out.println("4. SELECT TODOS"); 
            System.out.println("5. SELECT POR CÓDIGO"); 

            opcao = input.nextInt();
            input.nextLine();
            
            switch(opcao) {
                case 1:
                    System.out.println("\nInserindo novo produto...");
                    System.out.println("Insira o nome: ");
                    nome = input.nextLine();

                    System.out.println("Insira o valor (R$): ");
                    valor = input.nextDouble();

                    produto.setNome(nome);
                    produto.setValor(valor);
                    produto.setDataValidade(calendar);
                    
                    dao.gravar(produto);
                    
                    System.out.println("\nProduto inserido com sucesso!");
                break;
                
                case 2:
                    System.out.println("\nRemovendo produto...");
                    System.out.println("Insira o código: ");
                    codigo = input.nextInt();
                    input.nextLine();
                    
                    dao.remover(codigo);
                    
                    System.out.println("\nProduto removido com sucesso!");
                break;
                
                case 3:
                    System.out.println("\nAtualizando dados do produto...");
                    System.out.println("Insira o nome: ");
                    nome = input.nextLine();
                    
                    System.out.println("Insira o valor (R$): ");
                    valor = input.nextDouble();
                    input.nextLine();
                    
                    System.out.println("Insira o código do produto que deseja atualizar: ");
                    codigo = input.nextInt();
                    input.nextLine();

                    produto.setNome(nome);
                    produto.setValor(valor);
                    produto.setDataValidade(calendar);
                    produto.setCodigo(codigo);
                    
                    dao.atualizar(produto);
                    
                    System.out.println("\nProduto atualizado com sucesso!");
                break;
                
                case 4:
                    System.out.println("\nTabela:");
                    List<Produto> produtos = dao.buscarTodos();
                    
                    for (Produto prod: produtos) {
                        System.out.println(prod.toString());
                    }
                break;
                
                case 5:
                    System.out.println("\nBuscando produto...");
                    System.out.println("Insira o código do produto que deseja buscar: ");
                    codigo = input.nextInt();
                    input.nextLine();
                    
                    produto = dao.buscarTodosPorCodigo(codigo);
                    
                    System.out.println(produto.toString());
                break;
                
                default:
                    System.out.println("Escolha inválida!");
            }
            
            System.out.println("\nDeseja continuar? Digite true se SIM ou false se NÃO");
            continuaLoop = input.nextBoolean();
            input.nextLine();
            
        } while(continuaLoop == true);
        
        System.out.println("\nPrograma encerrado!");
        
        input.close();
	} 
	
}
