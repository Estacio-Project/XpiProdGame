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

import br.edu.estacio.expiprodgame.bean.Cliente;
import br.edu.estacio.expiprodgame.repository.Clientes;
import br.edu.estacio.expiprodgame.repository.filter.ClienteFilter;


@Controller
@RequestMapping("/clientes")
public class ClientesController {


	/*@Autowired
	private ClientesController clienteController;*/
	
	@Autowired
	private Clientes clientes;

	@GetMapping("/novo")
	public ModelAndView novo(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/cadastro-cliente");
		mv.addObject(cliente);
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cliente);
		}
		//System.out.println(cliente.toString());
		clientes.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
		return new ModelAndView("redirect:/clientes/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(ClienteFilter clienteFilter) {
		ModelAndView mv = new ModelAndView("cliente/pesquisa-cliente");
		mv.addObject("clientes", clientes.findByNomeContainingIgnoreCase(
				Optional.ofNullable(clienteFilter.getNome()).orElse("%")));
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Cliente cliente = clientes.findOne(id);
		
		return novo(cliente);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		clientes.delete(id);
		attributes.addFlashAttribute("mensagem", "Cliente removido com sucesso");
		return "redirect:/clientes";
	}

	
}
