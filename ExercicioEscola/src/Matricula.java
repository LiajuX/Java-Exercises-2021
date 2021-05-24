import java.util.Scanner;

public class Matricula {

  public static void main(String[] args) {
    CadastroCursos curso = new CadastroCursos();

    CadastroAlunos aluno = new CadastroAlunos();

    Scanner input = new Scanner(System.in);

    System.out.println("Cadastrando curso...");
    curso.cadastrarCurso(input);

    System.out.println("\nCadastrando aluno...");
    aluno.cadastrarAluno(input);

    System.out.println("\nDados do curso escolhido:");
    System.out.println("ID: " + curso.id);
    System.out.println("Nome: " + curso.nome);
    System.out.println("Vagas disponíveis: " + curso.quantidadeDeVagasDisponiveis);
    System.out.println("Período letivo: " + curso.periodoLetivo);
    System.out.println("Início das aulas: " + curso.inicioDasAulas + " / Fim das aulas: " + curso.fimDasAulas);

    System.out.println("\nDados do aluno(a):");
    System.out.println("Número de registro: " + aluno.numeroDeRegistro);
    System.out.println("Nome: " + aluno.nome);
    System.out.println("CPF: " + aluno.CPF);
    System.out.println("Endereço: " + aluno.endereco);
    System.out.println("Telefone: " + aluno.telefone);
  }

}
