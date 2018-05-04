package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Monitorconsumo;

public interface MonitorConsumos extends JpaRepository<Monitorconsumo,Long> {

	public List<Monitorconsumo> findBySituacaoContainingIgnoreCase(String situacao);

}
