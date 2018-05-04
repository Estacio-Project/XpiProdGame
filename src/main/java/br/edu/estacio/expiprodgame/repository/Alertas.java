package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Alerta;

public interface Alertas extends JpaRepository<Alerta,Long> {

	public List<Alerta> findByNomeContainingIgnoreCase(String nome);

}
