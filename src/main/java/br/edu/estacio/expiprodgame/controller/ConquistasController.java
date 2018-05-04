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

import br.edu.estacio.expiprodgame.bean.Conquista;
import br.edu.estacio.expiprodgame.repository.Conquistas;
import br.edu.estacio.expiprodgame.repository.filter.ConquistaFilter;


@Controller
@RequestMapping("/conquistas")
public class ConquistasController {


	/*@Autowired
	private ConquistasController conquistaController;*/
	
	@Autowired
	private Conquistas conquistas;

	@GetMapping("/novo")
	public ModelAndView novo(Conquista conquista) {
		ModelAndView mv = new ModelAndView("conquista/cadastro-conquista");
		mv.addObject(conquista);
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Conquista conquista, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(conquista);
		}
		//System.out.println(conquista.toString());
		conquistas.save(conquista);
		attributes.addFlashAttribute("mensagem", "Conquista salvo com sucesso!");
		return new ModelAndView("redirect:/conquistas/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(ConquistaFilter conquistaFilter) {
		ModelAndView mv = new ModelAndView("conquista/pesquisa-conquista");
		mv.addObject("conquistas", conquistas.findByNomeContainingIgnoreCase(
				Optional.ofNullable(conquistaFilter.getNome()).orElse("%")));
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Conquista conquista = conquistas.findOne(id);
		
		return novo(conquista);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		conquistas.delete(id);
		attributes.addFlashAttribute("mensagem", "Conquista removido com sucesso");
		return "redirect:/conquistas";
	}

	
}
