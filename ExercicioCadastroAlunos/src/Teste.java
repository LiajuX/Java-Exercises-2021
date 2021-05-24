import java.util.Scanner;

public class Teste {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Quantos alunos você quer cadastrar em cada sala?");
    int n = input.nextInt();

    CadastroSala[] alunos = new CadastroSala[n];

    System.out.println("Quantas salas você deseja cadastrar?");
    int quantidade = input.nextInt();

    input.nextLine();

    for (int i = 0; i < quantidade; i++) {
      System.out.println("Cadastrando alunos do " + (i + 1) + "° ano...");

      for (int j = 0; j < alunos.length; j++) {
        CadastroSala aluno = new CadastroSala();

        System.out.println("Insira o nome do aluno n°" + (j + 1) + ": ");
        aluno.setAluno(input.nextLine());

        alunos[j] = aluno;
      }

      int c = 0;

      for (CadastroSala aluno : alunos) {
        if (c < alunos.length) {
          c++;
        }

        System.out.println("Nome do aluno n°" + c + " do " + (i + 1) + "° ano: " + aluno.getAluno());
      }
    }

  }
}
