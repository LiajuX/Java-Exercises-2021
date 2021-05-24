import java.util.Scanner;

public class CadastroVacinados {
  private String nome;
  private String carteirinhaSUS;
  private String vacinaRecebida;
  private String dataDaSegundaDose;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCarteirinhaSUS() {
    return carteirinhaSUS;
  }

  public void setCarteirinhaSUS(String carteirinhaSUS) {
    this.carteirinhaSUS = carteirinhaSUS;
  }

  public String getVacinaRecebida() {
    return vacinaRecebida;
  }

  public void setVacinaRecebida(String vacinaRecebida) {
    this.vacinaRecebida = vacinaRecebida;
  }

  public String getDataDaSegundaDose() {
    return dataDaSegundaDose;
  }

  public void setDataDaSegundaDose(String dataDaSegundaDose) {
    this.dataDaSegundaDose = dataDaSegundaDose;
  }
}
