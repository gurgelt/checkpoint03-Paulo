package br.com.fiap.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.fiap.entity.Produto;


public class ProdutoDAOImpl extends HibernateGenericDAO<Produto, Long> {

	private static ProdutoDAOImpl instance = null;
	
	public static ProdutoDAOImpl getInstance() {
		if (instance == null) {
			instance = new ProdutoDAOImpl();
		}
		
		return instance;
	}
	
	private ProdutoDAOImpl() {
		super(Produto.class);
	}
	
	public List<Produto> listarPorValor(int valor, EntityManager entityManager) {
		TypedQuery<Produto> consulta = entityManager.createNamedQuery("Produto.listarPorValor", Produto.class);
		consulta.setParameter("valor", valor);
		
		return consulta.getResultList();
	}

}
