package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Cliente;

public interface Clientes extends JpaRepository<Cliente,Long> {

	public List<Cliente> findByNomeContainingIgnoreCase(String nome);

}
