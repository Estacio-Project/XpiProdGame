package br.edu.estacio.expiprodgame.controller;

import java.util.ArrayList;
import java.util.List;

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
import br.edu.estacio.expiprodgame.bean.Armazenamentoproduto;
import br.edu.estacio.expiprodgame.repository.Alertas;
import br.edu.estacio.expiprodgame.repository.ArmazenamentoProdutos;
import br.edu.estacio.expiprodgame.repository.Armazenamentos;
import br.edu.estacio.expiprodgame.repository.Produtos;
import br.edu.estacio.expiprodgame.repository.Vendas;
import br.edu.estacio.expiprodgame.repository.filter.ProdutoFilter;

@Controller
@RequestMapping("/armazenamentoprodutos")
public class ArmazenamentoProdutosController {


	/*@Autowired
	private UsuarioController usuarioController;*/
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private Armazenamentos armazenamentos;
	
	@Autowired
	private ArmazenamentoProdutos armazenamentoprodutos;

	@Autowired
	private Vendas vendas;
	
	@Autowired
	private Alertas alertas;
	
	@GetMapping("/novo")
	public ModelAndView novo(Armazenamentoproduto armazenamentoproduto) {
		ModelAndView mv = new ModelAndView("armazenamentoproduto/cadastro-armazenamentoproduto");
		
		mv.addObject(armazenamentoproduto);
		mv.addObject("armazenamentos", armazenamentos.findAll());
		mv.addObject("produtos", produtos.findAll());
		
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView salvarArmazenamentoproduto(@Valid Armazenamentoproduto armazenamentoproduto, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(armazenamentoproduto);
		}
		//armazenamentoproduto.getUsuario().getBadges().add(armazenamentoproduto.getBadge());
		armazenamentoprodutos.save(armazenamentoproduto);
		attributes.addFlashAttribute("mensagem", "ArmazenamentoProduto salvo com sucesso!");
		return new ModelAndView("redirect:/armazenamentoprodutos/novo");
	}
	
	@GetMapping("/novo-produto-transacao")
	public ModelAndView novoProdutoTransacao(Armazenamentoproduto armazenamentoproduto) {
		ModelAndView mv = new ModelAndView("armazenamentoproduto/cadastro-armazenamentoprodutotransacao");
		
		mv.addObject(armazenamentoproduto);
		mv.addObject("armazenamentos", armazenamentos.findAll());
		mv.addObject("vendas", vendas.findAll());
		
		return mv;
	}
	
	@GetMapping("/monitorar-produto-armazenamento")
	public ModelAndView gerarAlertaMonitoramentoArmazenamento() {
	
		List<Armazenamentoproduto>  listArmazProd = armazenamentoprodutos.findAll();
		List<Alerta> listAlertas = new ArrayList<Alerta>();
		
		
		for (Armazenamentoproduto armazenamentoproduto : listArmazProd) {
			float decisao = armazenamentoproduto.conteDiasRestantes(armazenamentoproduto.getProduto().getData_vencimento());
		
				Alerta alerta = new Alerta();
				alerta.setData_expiracao(armazenamentoproduto.getProduto().getData_vencimento());
				alerta.setNome("[ "+ armazenamentoproduto.getProduto().getNome() + " no(a) " + armazenamentoproduto.getArmazenamento().getNome() +" - "+ armazenamentoproduto.verificaSituacaoProduto(decisao) + " ]");
				alerta.setDescricao( " " + armazenamentoproduto.getProduto().getNome() + " tem " + Math.abs(decisao) + " dia(s) para " + armazenamentoproduto.verificaSituacaoProduto(decisao)  );
				if(armazenamentoproduto.getArmazenamento().getCliente() != null){
					alerta.setUsuario(armazenamentoproduto.getArmazenamento().getCliente().getUsuario());
				}
				if(armazenamentoproduto.getArmazenamento().getFornecedor() != null){
					alerta.setUsuario(armazenamentoproduto.getArmazenamento().getFornecedor().getUsuario());
				}
				listAlertas.add(alerta);
			
		}
		
		alertas.save(listAlertas);
		
		
		return new ModelAndView("redirect:/alertas");
	}
	
	@PostMapping("/novo-produto-transacao")
	public ModelAndView salvarArmazenamentoprodutoTransacao(@Valid Armazenamentoproduto armazenamentoproduto, BindingResult result, 
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novoProdutoTransacao(armazenamentoproduto);
		}
		//armazenamentoproduto.getUsuario().getBadges().add(armazenamentoproduto.getBadge());
		armazenamentoprodutos.save(armazenamentoproduto);
		attributes.addFlashAttribute("mensagem", "ArmazenamentoProduto salvo com sucesso!");
		return new ModelAndView("redirect:/armazenamentoprodutos/novo-produto-transacao");
	}
	
	@GetMapping
	public ModelAndView pesquisar(ProdutoFilter produtoFilter) {
		ModelAndView mv = new ModelAndView("armazenamentoproduto/pesquisa-armazenamentoproduto");
	
		mv.addObject("produtos", produtos.findAll());
		
		
		
		mv.addObject("armazenamentoprodutos", armazenamentoprodutos.findAll());
		
		return mv;
	}
	//pesquisar produtos apenas que esteve em transacao
	/*@GetMapping
	public ModelAndView pesquisarProdutoTransicao(ProdutoFilter produtoFilter) {
		ModelAndView mv = new ModelAndView("armazenamentoproduto/pesquisa-armazenamentoprodutotransacao");
	
		mv.addObject("vendas", vendas.findAll());
		
		
		
		mv.addObject("armazenamentoprodutos", armazenamentoprodutos.findAll());
		
		return mv;
	}*/
	
	@GetMapping("/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Armazenamentoproduto armazenamentoproduto = armazenamentoprodutos.findOne(id);
		
		return novo(armazenamentoproduto);
	}
	
	@DeleteMapping("/{id}")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		//usuarioController.excluir(new Usuario(), id.intValue());
		armazenamentoprodutos.delete(id);
		attributes.addFlashAttribute("mensagem", "Armazenamentoproduto removido com sucesso");
		return "redirect:/armazenamentoprodutos";
	}

	
}
