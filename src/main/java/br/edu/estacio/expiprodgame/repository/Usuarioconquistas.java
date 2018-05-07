package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Usuarioconquista;

public interface Usuarioconquistas extends JpaRepository<Usuarioconquista,Long> {

/*	public List<Usuarioconquista> findById(Long id);
*/	public List<Usuarioconquista> findByUsuarioId(Long id);


}
