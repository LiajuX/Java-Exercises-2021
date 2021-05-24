import java.util.Scanner;

public class CadastroCursos {
  int id = 0;
  String nome;
  String descricao;
  int quantidadeDeVagasDisponiveis;
  String periodoLetivo;
  String inicioDasAulas;
  String fimDasAulas;

  public void cadastrarCurso(Scanner input) {
    System.out.println("Nome do curso:");
    nome = input.nextLine();

    System.out.println("Descrição do curso:");
    descricao = input.nextLine();

    input.nextLine();

    System.out.println("Quantidade de vagas disponíveis no curso:");
    quantidadeDeVagasDisponiveis = input.nextInt();

    input.nextLine();

    System.out.println("Período letivo do curso:");
    periodoLetivo = input.nextLine();

    System.out.println("Início das aulas:");
    inicioDasAulas = input.nextLine();

    System.out.println("Fim das aulas:");
    fimDasAulas = input.nextLine();

    id++;
  }
}
