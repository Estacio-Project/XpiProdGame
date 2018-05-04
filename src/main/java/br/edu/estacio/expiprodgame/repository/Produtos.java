package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Produto;
import br.edu.estacio.expiprodgame.bean.Usuario;

public interface Produtos extends JpaRepository<Produto,Long> {

	public List<Produto> findByNomeContainingIgnoreCase(String nome);

}
