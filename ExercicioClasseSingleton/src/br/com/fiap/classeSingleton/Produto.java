package br.com.fiap.classeSingleton;

public class Produto {
	private String nome;
	private java.sql.Date dataValidade;
	private Double valor;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public java.sql.Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(java.sql.Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}	
}
