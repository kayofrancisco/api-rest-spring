package br.com.spring.produto.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.produto.models.Produto;

@Service
public class AcaoProduto implements InterfaceProduto{
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@Override
	public List<Produto> getAllProdutos() {
		List<Produto> produtos = new ArrayList<>();
		produtoRepositorio.findAll().forEach(produto -> produtos.add(produto));

		return produtos;
	}

	@Override
	public Produto getProdutoById(long id) {
		Produto produto = produtoRepositorio.findById(id).get();
		return produto;		
		}

	@Override
	public boolean addProduto(Produto produto) {
		produtoRepositorio.save(produto);
		return true;
	}

	@Override
	public void updateProduto(Produto produto) {
		produtoRepositorio.save(produto);
	}

	@Override
	public void deleteProduto(Produto produto) {
		produtoRepositorio.delete(produto);
	}


}
