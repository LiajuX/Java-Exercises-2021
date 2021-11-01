package br.com.fiap.mercado.dao;

import java.util.List;

import br.com.fiap.mercado.entity.Produto;

public interface ProdutoDAO {
	void gravar(Produto produto);
	
	List<Produto> buscarTodos();
	
	Produto buscarTodosPorCodigo(int codigo);
	
	void atualizar(Produto produto);
	
	void remover(int codigo);
}
