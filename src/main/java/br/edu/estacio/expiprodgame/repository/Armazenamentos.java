package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Armazenamento;

public interface Armazenamentos extends JpaRepository<Armazenamento,Long> {

	public List<Armazenamento> findByNomeContainingIgnoreCase(String nome);

}
