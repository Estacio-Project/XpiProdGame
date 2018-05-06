package br.edu.estacio.expiprodgame.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.estacio.expiprodgame.bean.Armazenamento;
import br.edu.estacio.expiprodgame.repository.Armazenamentos;
import br.edu.estacio.expiprodgame.repository.Clientes;
import br.edu.estacio.expiprodgame.repository.Fornecedores;
import br.edu.estacio.expiprodgame.repository.Produtos;
import br.edu.estacio.expiprodgame.repository.filter.ArmazenamentoFilter;


@Controller
@RequestMapping("/armazenamentos")
public class ArmazenamentosController {


	/*@Autowired
	private ArmazenamentosController armazenamentoController;*/
	
	@Autowired
	private Armazenamentos armazenamentos;
	@Autowired
	private Clientes clientes;
	
	@Autowired
	private Fornecedores fornecedores;
	
	@Autowired
	private Produtos produtos;
	

	@GetMapping("/novo-cliente")
	public ModelAndView novoCliente(Armazenamento armazenamento) {
		ModelAndView mv = new ModelAndView("armazenamento/cadastro-armazenamento-cliente");
		mv.addObject(armazenamento);
		mv.addObject("clientes",clientes.findAll());
		
		return mv;
	}
	
	@PostMapping("/novo-cliente")
	public ModelAndView salvarCliente(@Valid Armazenamento armazenamento, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novoCliente(armazenamento);
		}
		//System.out.println(armazenamento.toString());
		armazenamentos.save(armazenamento);
		attributes.addFlashAttribute("mensagem", "Armazenamento salvo com sucesso!");
		return new ModelAndView("redirect:/armazenamentos/novo");
	}
	
	@GetMapping("/novo-fornecedor")
	public ModelAndView novoFornecedor(Armazenamento armazenamento) {
		ModelAndView mv = new ModelAndView("armazenamento/cadastro-armazenamento-fornecedor");
		mv.addObject(armazenamento);
		mv.addObject("fornecedores",fornecedores.findAll());
		return mv;
	}
	
	@PostMapping("/novo-fornecedor")
	public ModelAndView salvarFornecedor(@Valid Armazenamento armazenamento, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novoFornecedor(armazenamento);
		}
		//System.out.println(armazenamento.toString());
		armazenamentos.save(armazenamento);
		attributes.addFlashAttribute("mensagem", "Armazenamento salvo com sucesso!");
		return new ModelAndView("redirect:/armazenamentos/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(ArmazenamentoFilter armazenamentoFilter) {
		ModelAndView mv = new ModelAndView("armazenamento/pesquisa-armazenamento");
		mv.addObject("armazenamentos", armazenamentos.findByNomeContainingIgnoreCase(
				Optional.ofNullable(armazenamentoFilter.getNome()).orElse("%")));
		return mv;
	}
	
	
	@GetMapping("/novo")
	public ModelAndView novo(Armazenamento armazenamento) {
		ModelAndView mv = new ModelAndView("armazenamento/cadastro-armazenamento");
		mv.addObject(armazenamento);
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Armazenamento armazenamento, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(armazenamento);
		}
		//System.out.println(armazenamento.toString());
		armazenamentos.save(armazenamento);
		attributes.addFlashAttribute("mensagem", "Armazenamento salvo com sucesso!");
		return new ModelAndView("redirect:/armazenamentos/novo");
	}
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Armazenamento armazenamento = armazenamentos.findOne(id);
		
		return novo(armazenamento);
	}
	
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		armazenamentos.delete(id);
		attributes.addFlashAttribute("mensagem", "Armazenamento removido com sucesso");
		return "redirect:/armazenamentos";
	}

	
}
