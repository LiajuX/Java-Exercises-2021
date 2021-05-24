import java.util.Random;
import java.util.Scanner;

public class CadastroVeiculos {
  Random random = new Random();

  int id = random.nextInt();
  String classificacao;
  String cor;
  String nivelDeCombustivel;
  int quilometrosRodados;

  public void cadastrarVeiculos(Scanner input) {
    System.out.println("Classificação do veículo: ");
    classificacao = input.nextLine();

    System.out.println("Cor do veículo: ");
    cor = input.nextLine();

    System.out.println("Nível de combustível do veículo: ");
    nivelDeCombustivel = input.nextLine();

    input.nextLine();

    System.out.println("Quilômetros rodados: ");
    quilometrosRodados = input.nextInt();
  }
}
