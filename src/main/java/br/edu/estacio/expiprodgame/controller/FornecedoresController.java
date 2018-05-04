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

import br.edu.estacio.expiprodgame.bean.Fornecedor;
import br.edu.estacio.expiprodgame.repository.Fornecedores;
import br.edu.estacio.expiprodgame.repository.filter.FornecedorFilter;


@Controller
@RequestMapping("/fornecedores")
public class FornecedoresController {


	/*@Autowired
	private FornecedorsController fornecedorController;*/
	
	@Autowired
	private Fornecedores fornecedores;

	@GetMapping("/novo")
	public ModelAndView novo(Fornecedor fornecedor) {
		ModelAndView mv = new ModelAndView("fornecedor/cadastro-fornecedor");
		mv.addObject(fornecedor);
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Fornecedor fornecedor, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(fornecedor);
		}
		//System.out.println(fornecedor.toString());
		fornecedores.save(fornecedor);
		attributes.addFlashAttribute("mensagem", "Fornecedor salvo com sucesso!");
		return new ModelAndView("redirect:/fornecedores/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(FornecedorFilter fornecedorFilter) {
		ModelAndView mv = new ModelAndView("fornecedor/pesquisa-fornecedor");
		mv.addObject("fornecedores", fornecedores.findByNomeContainingIgnoreCase(
				Optional.ofNullable(fornecedorFilter.getNome()).orElse("%")));
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Fornecedor fornecedor = fornecedores.findOne(id);
		
		return novo(fornecedor);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		//fornecedorController.excluir(new Fornecedor(), id.intValue());
		fornecedores.delete(id);
		attributes.addFlashAttribute("mensagem", "Fornecedor removido com sucesso");
		return "redirect:/fornecedores";
	}

	
}
