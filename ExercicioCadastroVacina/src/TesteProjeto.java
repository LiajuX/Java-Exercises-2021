import java.util.ArrayList;
import java.util.Scanner;

public class TesteProjeto {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<CadastroVacinados> vacinados = new ArrayList<>();

    boolean continuar = true;
    int i = 0;

    do {
      i++;
      CadastroVacinados vacinado = new CadastroVacinados();

      System.out.println("\nCadastrando " + i + "ª pessoa a ser vacinada");
      System.out.println("Insira o nome da pessoa vacinada: ");
      vacinado.setNome(input.nextLine());

      System.out.println("Insira o número da carteirinha do SUS: ");
      vacinado.setCarteirinhaSUS(input.nextLine());

      System.out.println("Insira o nome da vacina recebida: ");
      vacinado.setVacinaRecebida(input.nextLine());

      System.out.println("Insira a data da segunda dose: ");
      vacinado.setDataDaSegundaDose(input.nextLine());

      vacinados.add(vacinado);

      System.out.println("\nDeseja cadastrar outra pessoa? Responda com sim ou não.");
      if (!input.nextLine().equalsIgnoreCase("sim")) {
        continuar = false;
      }
    } while (continuar);

    System.out.println("\nPessoas vacinadas:");

    for (i = 0; i < vacinados.size(); i++) {
      CadastroVacinados vacinado = vacinados.get(i);

      System.out.println("\nDados da " + (i + 1) + "° pessoa a ser vacinada:");
      System.out.println("Nome: " + vacinado.getNome());
      System.out.println("N° da carteirinha do SUS: " + vacinado.getCarteirinhaSUS());
      System.out.println("Vacina recebida: " + vacinado.getVacinaRecebida());
      System.out.println("Data de retorno para a 2ª dose: " + vacinado.getDataDaSegundaDose());
    }
  }
}
