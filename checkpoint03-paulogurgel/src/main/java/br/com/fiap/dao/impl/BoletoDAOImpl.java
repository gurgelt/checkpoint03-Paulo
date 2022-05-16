package br.com.fiap.dao.impl;

import br.com.fiap.entity.Boleto;

public class BoletoDAOImpl extends HibernateGenericDAO<Boleto, Long> {

	private static BoletoDAOImpl instance = null;
	
	public static BoletoDAOImpl getInstance() {
		if (instance == null) {
			instance = new BoletoDAOImpl();
		}
		
		return instance;
	}
	
	private BoletoDAOImpl() {
		super(Boleto.class);
	}

}