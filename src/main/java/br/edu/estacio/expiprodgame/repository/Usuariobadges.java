package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Usuario;
import br.edu.estacio.expiprodgame.bean.Usuariobadge;

public interface Usuariobadges extends JpaRepository<Usuariobadge,Long> {

/*	public List<Usuariobadge> findById(Long id);
*/	public List<Usuariobadge> findByUsuarioId(Long id);


}
