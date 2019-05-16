package br.com.spring.produto.repositorio;

import java.util.List;

import br.com.spring.produto.models.Produto;

public interface InterfaceProduto {
	 List<Produto> getAllProdutos();
	 Produto getProdutoById(long id);
     boolean addProduto(Produto produto);
     void updateProduto(Produto produto);
     void deleteProduto(Produto produto);
}
