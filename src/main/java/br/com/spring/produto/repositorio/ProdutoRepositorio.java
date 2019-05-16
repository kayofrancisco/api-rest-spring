package br.com.spring.produto.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.spring.produto.models.Produto;

public interface ProdutoRepositorio extends CrudRepository<Produto, Long> {
}
