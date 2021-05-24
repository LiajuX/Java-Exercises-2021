import java.util.Random;
import java.util.Scanner;

public class CadastroClientes {
  Random random = new Random();

  int id = random.nextInt();
  String nome;
  String CPF;
  String telefone;

  public void cadastrarClientes(Scanner input) {
    System.out.println("Nome do cliente: ");
    nome = input.nextLine();

    System.out.println("CPF do cliente: ");
    CPF = input.nextLine();

    System.out.println("Telefone do cliente: ");
    telefone = input.nextLine();
  }
}
