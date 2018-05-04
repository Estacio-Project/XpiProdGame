package br.edu.estacio.expiprodgame.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.estacio.expiprodgame.bean.Produto;
import br.edu.estacio.expiprodgame.repository.Produtos;
import br.edu.estacio.expiprodgame.repository.filter.ProdutoFilter;


@Controller
@RequestMapping("/produtos")
public class ProdutosController {


	/*@Autowired
	private ProdutosController produtoController;*/
	
	@Autowired
	private Produtos produtos;

	@GetMapping("/novo")
	public ModelAndView novo(Produto produto) {
		ModelAndView mv = new ModelAndView("produto/cadastro-produto");
		mv.addObject(produto);
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Produto produto, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(produto);
		}
		System.out.println(produto.toString());
		produtos.save(produto);
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
		return new ModelAndView("redirect:/produtos/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(ProdutoFilter loginFilter) {
		ModelAndView mv = new ModelAndView("produto/pesquisa-produto");
		mv.addObject("produtos", produtos.findByNomeContainingIgnoreCase(
				Optional.ofNullable(loginFilter.getNome()).orElse("%")));
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Produto produto = produtos.findOne(id);
		
		return novo(produto);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		//produtoController.excluir(new Produto(), id.intValue());
		produtos.delete(id);
		attributes.addFlashAttribute("mensagem", "Produto removido com sucesso");
		return "redirect:/produtos";
	}

	
}
