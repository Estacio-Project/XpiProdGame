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


import br.edu.estacio.expiprodgame.bean.Monitorconsumo;
import br.edu.estacio.expiprodgame.repository.MonitorConsumos;
import br.edu.estacio.expiprodgame.repository.filter.MonitorConsumoFilter;
import br.edu.estacio.expiprodgame.util.TipoEstadoConsumo;


@Controller
@RequestMapping("/monitorconsumos")
public class MonitorConsumosController {


	/*@Autowired
	private MonitorConsumosController monitorconsumoController;*/
	
	@Autowired
	private MonitorConsumos monitorconsumos;

	@GetMapping("/novo")
	public ModelAndView novo(Monitorconsumo monitorconsumo) {
		ModelAndView mv = new ModelAndView("monitorconsumo/cadastro-monitorconsumo");
		mv.addObject(monitorconsumo);
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Valid Monitorconsumo monitorconsumo, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(monitorconsumo);
		}
		//System.out.println(monitorconsumo.toString());
		monitorconsumos.save(monitorconsumo);
		attributes.addFlashAttribute("mensagem", "Monitorconsumo salvo com sucesso!");
		return new ModelAndView("redirect:/monitorconsumos/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisar(MonitorConsumoFilter monitorconsumoFilter) {
		ModelAndView mv = new ModelAndView("monitorconsumo/pesquisa-monitorconsumo");
		mv.addObject("monitorconsumos", monitorconsumos.findBySituacaoContainingIgnoreCase(
				Optional.ofNullable(monitorconsumoFilter.getSituacao()).orElse("%")));
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Monitorconsumo monitorconsumo = monitorconsumos.findOne(id);
		
		return novo(monitorconsumo);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		monitorconsumos.delete(id);
		attributes.addFlashAttribute("mensagem", "Monitorconsumo removido com sucesso");
		return "redirect:/monitorconsumos";
	}

	
}
