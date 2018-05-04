package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Fornecedor;

public interface Fornecedores extends JpaRepository<Fornecedor,Long> {

	public List<Fornecedor> findByNomeContainingIgnoreCase(String nome);

}
