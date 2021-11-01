package br.com.fiap.mercado.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nome;
	private double valor;
	private Calendar dataValidade;
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return "Produto [codigo = " + codigo
									+ ", nome = " + nome
									+ ", valor = " + valor
									+ ", dataValidade = "
									+ sdf.format(dataValidade.getTime())
				+ "]";
	}
	
	public Produto(int codigo, String nome, double valor, Calendar dataValidade) {
		super();
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setValor(valor);
		this.setDataValidade(dataValidade);
	}
	
	public Produto() {}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	};
}
