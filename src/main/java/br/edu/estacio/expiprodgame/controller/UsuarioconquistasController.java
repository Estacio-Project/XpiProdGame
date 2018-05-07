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

import br.edu.estacio.expiprodgame.bean.Usuarioconquista;
import br.edu.estacio.expiprodgame.repository.Conquistas;
import br.edu.estacio.expiprodgame.repository.Usuarioconquistas;
import br.edu.estacio.expiprodgame.repository.Usuarios;
import br.edu.estacio.expiprodgame.repository.filter.UsuarioFilter;

@Controller
@RequestMapping("/usuarioconquistas")
public class UsuarioconquistasController {


	/*@Autowired
	private UsuarioController usuarioController;*/
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Conquistas conquistas;
	
	@Autowired
	private Usuarioconquistas usuarioconquistas;

	
	@GetMapping("/novo")
	public ModelAndView novo(Usuarioconquista usuarioconquista) {
		ModelAndView mv = new ModelAndView("usuarioconquista/cadastro-usuarioconquista");
		
		mv.addObject(usuarioconquista);
		mv.addObject("conquistas", conquistas.findAll());
		mv.addObject("usuarios", usuarios.findAll());
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvarUsuarioconquista(@Valid Usuarioconquista usuarioconquista, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(usuarioconquista);
		}
		//usuarioconquista.getUsuario().getConquistas().add(usuarioconquista.getBadge());
		usuarioconquistas.save(usuarioconquista);
		attributes.addFlashAttribute("mensagem", "UsuarioBadge salvo com sucesso!");
		return new ModelAndView("redirect:/usuarioconquistas/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(UsuarioFilter usuarioFilter) {
		ModelAndView mv = new ModelAndView("usuarioconquista/pesquisa-usuarioconquista");
	
		mv.addObject("usuarios", usuarios.findAll());
		
		
		
		mv.addObject("usuarioconquistas", usuarioconquistas.findAll());
		
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Usuarioconquista usuarioconquista = usuarioconquistas.findOne(id);
		
		return novo(usuarioconquista);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		//usuarioController.excluir(new Usuario(), id.intValue());
		usuarioconquistas.delete(id);
		attributes.addFlashAttribute("mensagem", "Usuarioconquista removido com sucesso");
		return "redirect:/usuarioconquistas";
	}

	
}
