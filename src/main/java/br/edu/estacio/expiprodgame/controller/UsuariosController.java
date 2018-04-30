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

import br.edu.estacio.expiprodgame.bean.Usuario;
import br.edu.estacio.expiprodgame.repository.Usuarios;
import br.edu.estacio.expiprodgame.repository.filter.UsuarioFilter;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {


	/*@Autowired
	private UsuarioController usuarioController;*/
	
	@Autowired
	private Usuarios usuarios;

	@GetMapping("/novo")
	public ModelAndView novo(Usuario login) {
		ModelAndView mv = new ModelAndView("usuario/cadastro-usuario");
		mv.addObject(login);
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(usuario);
		}
		System.out.println(usuario.toString());
		usuarios.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso!");
		return new ModelAndView("redirect:/usuarios/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(UsuarioFilter loginFilter) {
		ModelAndView mv = new ModelAndView("usuario/pesquisa-usuario");
		mv.addObject("usuarios", usuarios.findByLoginContainingIgnoreCase(
				Optional.ofNullable(loginFilter.getLogin()).orElse("%")));
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Usuario usuario = usuarios.findOne(id);
		
		return novo(usuario);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		//usuarioController.excluir(new Usuario(), id.intValue());
		usuarios.delete(id);
		attributes.addFlashAttribute("mensagem", "Usuario removido com sucesso");
		return "redirect:/usuarios";
	}

	
}
