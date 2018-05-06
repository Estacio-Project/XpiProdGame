package br.edu.estacio.expiprodgame.controller;

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

import br.edu.estacio.expiprodgame.bean.Usuariobadge;
import br.edu.estacio.expiprodgame.repository.Badges;
import br.edu.estacio.expiprodgame.repository.Usuariobadges;
import br.edu.estacio.expiprodgame.repository.Usuarios;
import br.edu.estacio.expiprodgame.repository.filter.UsuarioFilter;

@Controller
@RequestMapping("/usuariobadges")
public class UsuariobadgesController {


	/*@Autowired
	private UsuarioController usuarioController;*/
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Badges badges;
	
	@Autowired
	private Usuariobadges usuariobadges;

	
	@GetMapping("/novo")
	public ModelAndView novo(Usuariobadge usuariobadge) {
		ModelAndView mv = new ModelAndView("usuariobadge/cadastro-usuariobadge");
		
		mv.addObject(usuariobadge);
		mv.addObject("badges", badges.findAll());
		mv.addObject("usuarios", usuarios.findAll());
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvarUsuariobadge(@Valid Usuariobadge usuariobadge, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(usuariobadge);
		}
		//usuariobadge.getUsuario().getBadges().add(usuariobadge.getBadge());
		usuariobadges.save(usuariobadge);
		attributes.addFlashAttribute("mensagem", "UsuarioBadge salvo com sucesso!");
		return new ModelAndView("redirect:/usuariobadges/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(UsuarioFilter usuarioFilter) {
		ModelAndView mv = new ModelAndView("usuariobadge/pesquisa-usuariobadge");
	
		mv.addObject("usuarios", usuarios.findAll());
		
		
		
		mv.addObject("usuariobadges", usuariobadges.findAll());
		
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Usuariobadge usuariobadge = usuariobadges.findOne(id);
		
		return novo(usuariobadge);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		//usuarioController.excluir(new Usuario(), id.intValue());
		usuariobadges.delete(id);
		attributes.addFlashAttribute("mensagem", "Usuariobadge removido com sucesso");
		return "redirect:/usuariobadges";
	}

	
}
