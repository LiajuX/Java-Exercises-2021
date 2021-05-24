import java.util.Scanner;

public class ParqueDeVeiculos {
  int quantidade;

  CadastroVeiculos veiculo = new CadastroVeiculos();

  public void atualizarParqueDeVeiculos(Scanner input) {
    System.out.println("Quantidade de veículos disponíveis: ");
    quantidade = input.nextInt();
  }
}
