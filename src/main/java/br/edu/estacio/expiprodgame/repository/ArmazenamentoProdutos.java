package br.edu.estacio.expiprodgame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.estacio.expiprodgame.bean.Armazenamentoproduto;
import br.edu.estacio.expiprodgame.bean.Produto;

public interface ArmazenamentoProdutos extends JpaRepository<Armazenamentoproduto,Long> {

/*	public List<Usuariobadge> findById(Long id);
*/	public List<Armazenamentoproduto> findByProduto(Produto produto);


}
