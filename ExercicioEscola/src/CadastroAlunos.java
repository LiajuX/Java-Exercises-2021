import java.util.Scanner;

public class CadastroAlunos {
  String nome;
  String CPF;
  String endereco;
  String telefone;
  int numeroDeRegistro = 0;

  public void cadastrarAluno(Scanner input) {
    System.out.println("Nome do aluno:");
    nome = input.nextLine();

    System.out.println("CPF do aluno:");
    CPF = input.nextLine();

    System.out.println("Endereço do aluno:");
    endereco = input.nextLine();

    System.out.println("Telefone do aluno e/ou responsável:");
    telefone = input.nextLine();

    numeroDeRegistro++;
  }
}
