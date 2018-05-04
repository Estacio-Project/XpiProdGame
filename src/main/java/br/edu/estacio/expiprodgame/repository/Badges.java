package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Badge;

public interface Badges extends JpaRepository<Badge,Long> {

	public List<Badge> findByNomeContainingIgnoreCase(String nome);

}
