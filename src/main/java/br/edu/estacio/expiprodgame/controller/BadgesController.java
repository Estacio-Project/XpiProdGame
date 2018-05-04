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

import br.edu.estacio.expiprodgame.bean.Badge;
import br.edu.estacio.expiprodgame.repository.Badges;
import br.edu.estacio.expiprodgame.repository.filter.BadgeFilter;


@Controller
@RequestMapping("/badges")
public class BadgesController {


	/*@Autowired
	private BadgesController badgeController;*/
	
	@Autowired
	private Badges badges;

	@GetMapping("/novo")
	public ModelAndView novo(Badge badge) {
		ModelAndView mv = new ModelAndView("badge/cadastro-badge");
		mv.addObject(badge);
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Badge badge, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(badge);
		}
		//System.out.println(badge.toString());
		badges.save(badge);
		attributes.addFlashAttribute("mensagem", "Badge salvo com sucesso!");
		return new ModelAndView("redirect:/badges/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(BadgeFilter badgeFilter) {
		ModelAndView mv = new ModelAndView("badge/pesquisa-badge");
		mv.addObject("badges", badges.findByNomeContainingIgnoreCase(
				Optional.ofNullable(badgeFilter.getNome()).orElse("%")));
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Badge badge = badges.findOne(id);
		
		return novo(badge);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		badges.delete(id);
		attributes.addFlashAttribute("mensagem", "Badge removido com sucesso");
		return "redirect:/badges";
	}

	
}
