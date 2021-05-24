import java.util.Scanner;

public class Aluguel {

  public static void main(String[] args) {

    CadastroClientes cliente = new CadastroClientes();

    ParqueDeVeiculos veiculoAlugado = new ParqueDeVeiculos();

    Scanner input = new Scanner(System.in);

    System.out.println("Cadastrando Cliente...");
    cliente.cadastrarClientes(input);

    System.out.println("\nCadastrando Veículo...");
    veiculoAlugado.veiculo.cadastrarVeiculos(input);

    System.out.println("\nAtualizando parque de veículos...");
    veiculoAlugado.atualizarParqueDeVeiculos(input);

    System.out.println("\nDados do cliente:");
    System.out.println("Número de identificação: " + cliente.id);
    System.out.println("Nome: " + cliente.nome);
    System.out.println("CPF: " + cliente.CPF);
    System.out.println("Telefone: " + cliente.telefone);

    System.out.println("\nDados do veículo:");
    System.out.println("Número de identificação: " + veiculoAlugado.veiculo.id);
    System.out.println("Classificação: " + veiculoAlugado.veiculo.classificacao);
    System.out.println("Cor: " + veiculoAlugado.veiculo.cor);
    System.out.println("Quilômetros rodados: " + veiculoAlugado.veiculo.quilometrosRodados);
    System.out.println("Nível de combustível: " + veiculoAlugado.veiculo.nivelDeCombustivel);
    System.out.println("Quantidade disponível na locadora: " + veiculoAlugado.quantidade);

  }

}
