package br.com.fiap.dao.impl;

import br.com.fiap.dao.impl.itemPedidoDAOImpl;
import br.com.fiap.entity.itemPedido;

public class itemPedidoDAOImpl extends HibernateGenericDAO<itemPedido, Long>{
	
private static itemPedidoDAOImpl instance = null;
	
	private itemPedidoDAOImpl() {
		super(itemPedido.class);
	}
	
	public static itemPedidoDAOImpl getInstance() {
		
		if (instance == null) {
			instance = new itemPedidoDAOImpl();
		}
		
		return instance;
	}

}
