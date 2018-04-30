package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Usuario;

public interface Usuarios extends JpaRepository<Usuario,Long> {

	public List<Usuario> findByLoginContainingIgnoreCase(String login);

}
