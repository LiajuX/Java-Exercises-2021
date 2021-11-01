package br.com.fiap.mercado.dao;

public abstract class DAOFactory {	
	public static ProdutoDAO getProdutoDAO() {
		return new ProdutoDAOImpl();
	}
}
