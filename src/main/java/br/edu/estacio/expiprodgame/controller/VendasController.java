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

import br.edu.estacio.expiprodgame.bean.Venda;
import br.edu.estacio.expiprodgame.repository.Vendas;
import br.edu.estacio.expiprodgame.repository.filter.VendaFilter;


@Controller
@RequestMapping("/vendas")
public class VendasController {


	/*@Autowired
	private VendasController vendaController;*/
	
	@Autowired
	private Vendas vendas;

	@GetMapping("/novo")
	public ModelAndView novo(Venda venda) {
		ModelAndView mv = new ModelAndView("venda/cadastro-venda");
		mv.addObject(venda);
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Venda venda, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(venda);
		}
		//System.out.println(venda.toString());
		vendas.save(venda);
		attributes.addFlashAttribute("mensagem", "Venda salvo com sucesso!");
		return new ModelAndView("redirect:/vendas/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(VendaFilter vendaFilter) {
		ModelAndView mv = new ModelAndView("venda/pesquisa-venda");
		mv.addObject("vendas", vendas.findByNomeContainingIgnoreCase(
				Optional.ofNullable(vendaFilter.getNome()).orElse("%")));
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Venda venda = vendas.findOne(id);
		
		return novo(venda);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		vendas.delete(id);
		attributes.addFlashAttribute("mensagem", "Venda removido com sucesso");
		return "redirect:/vendas";
	}

	
}
