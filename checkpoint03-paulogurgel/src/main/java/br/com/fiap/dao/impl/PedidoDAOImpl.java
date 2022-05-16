package br.com.fiap.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.fiap.dao.impl.PedidoDAOImpl;
import br.com.fiap.entity.Pedido;

public class PedidoDAOImpl extends HibernateGenericDAO<Pedido, Long>{

private static PedidoDAOImpl instance = null;
	
	private PedidoDAOImpl() {
		super(Pedido.class);
	}
	
	public static PedidoDAOImpl getInstance() {
		
		if (instance == null) {
			instance = new PedidoDAOImpl();
		}
		
		return instance;
	}
	
	public List<Pedido> listarPorCPF(String cpf, EntityManager entityManager) {
		String jpql =  "SELECT p FROM Pedido p WHERE p.cpfCliente = :cpf";
		TypedQuery<Pedido> consulta = entityManager.createNamedQuery(jpql, Pedido.class);
		consulta.setParameter("cpf", cpf);
		
		return consulta.getResultList();
	}
}
