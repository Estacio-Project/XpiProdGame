package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Conquista;

public interface Conquistas extends JpaRepository<Conquista,Long> {

	public List<Conquista> findByNomeContainingIgnoreCase(String nome);

}
