package br.com.spring.produto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.spring.produto.models.Produto;
import br.com.spring.produto.repositorio.AcaoProduto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller // Controle do componente spring
@RequestMapping("/produto")
@Api("Produto API REST")
@CrossOrigin(origins = "*")
public class ProdutosController {

	@Autowired
	private AcaoProduto acaoProduto;

	@GetMapping
	@ApiOperation(value = "Restorna todos os produtos cadastrados")
	public ModelAndView listarTodos() {
		ModelAndView modelAndView = new ModelAndView("listaProdutos");
		modelAndView.addObject("produtos", acaoProduto.getAllProdutos());
		modelAndView.addObject(new Produto());
		return modelAndView;
	}

	@PostMapping
	@ApiOperation(value = "Adiciona produto")
	public String salvar(Produto produto) {
		acaoProduto.addProduto(produto);
		return "redirect:/produto";
	}

	@DeleteMapping
	@ApiOperation(value = "Deleta produto")
	public String delete(@RequestBody Produto produto) {
		System.out.println(produto);
		acaoProduto.deleteProduto(produto);
		return "redirect:/produto";
	}

	@PutMapping
	@ApiOperation(value = "Atualiza produto")
	public String atualiza(@RequestBody Produto produto) {
		acaoProduto.addProduto(produto);
		return "redirect:/produto";
	}
}
