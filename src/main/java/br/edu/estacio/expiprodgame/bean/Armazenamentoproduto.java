package br.edu.estacio.expiprodgame.bean;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.estacio.expiprodgame.util.TipoEstadoConsumo;

@Entity
@IdClass(Armazenamentoprodutoid.class)
@Table(name = "armazenamento_produto")
public class Armazenamentoproduto {
	

	
	@Id
	@ManyToOne
	@JoinColumn(name="armazenamento_id")
	private Armazenamento armazenamento;
	
	@Id
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	@OneToOne
	@JoinColumn(name="alerta_id")
	private Alerta alerta;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_entrada;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_saida;

	private Integer quantidade;
	
	//private String situacao;
	//private Integer dias_restantes;
	
	//Tipo cadastro(avulso,transacao)

	
	public Armazenamento getArmazenamento() {
		return armazenamento;
	}


	public void setArmazenamento(Armazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	


	public Alerta getAlerta() {
		return alerta;
	}


	public void setAlerta(Alerta alerta) {
		this.alerta = alerta;
	}


	public Date getData_entrada() {
		return data_entrada;
	}


	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}


	public Date getData_saida() {
		return data_saida;
	}


	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	public String test(){
		return "test";
	}
	public float conteDiasRestantes(Date data_validade){
		Date data_atual = new Date();
		long diff = data_validade.getTime() - data_atual.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		
	}
	
	public String verificaSituacaoProduto(float dias_restantes){
		if(dias_restantes < 0){
			return TipoEstadoConsumo.FORA_VALIDADE.getDescricao();
		}else if(dias_restantes > 0){
			return TipoEstadoConsumo.DENTRO_VALIDADE.getDescricao();
		}
		
		return TipoEstadoConsumo.LIMITE_VALIDADE.getDescricao();
	
	}
	
}
