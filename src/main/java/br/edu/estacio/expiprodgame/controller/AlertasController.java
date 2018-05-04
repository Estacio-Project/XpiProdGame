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

import br.edu.estacio.expiprodgame.bean.Alerta;
import br.edu.estacio.expiprodgame.repository.Alertas;
import br.edu.estacio.expiprodgame.repository.filter.AlertaFilter;


@Controller
@RequestMapping("/alertas")
public class AlertasController {


	/*@Autowired
	private AlertasController alertaController;*/
	
	@Autowired
	private Alertas alertas;

	@GetMapping("/novo")
	public ModelAndView novo(Alerta alerta) {
		ModelAndView mv = new ModelAndView("alerta/cadastro-alerta");
		mv.addObject(alerta);
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Alerta alerta, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(alerta);
		}
		//System.out.println(alerta.toString());
		alertas.save(alerta);
		attributes.addFlashAttribute("mensagem", "Alerta salvo com sucesso!");
		return new ModelAndView("redirect:/alertas/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(AlertaFilter alertaFilter) {
		ModelAndView mv = new ModelAndView("alerta/pesquisa-alerta");
		mv.addObject("alertas", alertas.findByNomeContainingIgnoreCase(
				Optional.ofNullable(alertaFilter.getNome()).orElse("%")));
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Alerta alerta = alertas.findOne(id);
		
		return novo(alerta);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		alertas.delete(id);
		attributes.addFlashAttribute("mensagem", "Alerta removido com sucesso");
		return "redirect:/alertas";
	}

	
}
