package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Venda;


public interface Vendas extends JpaRepository<Venda,Long> {

	public List<Venda> findByNomeContainingIgnoreCase(String nome);

}
