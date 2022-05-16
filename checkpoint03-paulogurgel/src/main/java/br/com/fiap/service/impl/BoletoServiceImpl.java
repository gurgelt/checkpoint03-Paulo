package br.com.fiap.service.impl;

import java.util.List;
import br.com.fiap.dao.impl.BoletoDAOImpl;
import br.com.fiap.entity.Boleto;
import br.com.fiap.service.GenericService;

	public class BoletoServiceImpl extends GenericService<Boleto, Long> {

		private static BoletoServiceImpl instance = null;
		
		private BoletoDAOImpl boletoDAO;
		
		private BoletoServiceImpl() {
			boletoDAO = BoletoDAOImpl.getInstance();
		}
		
		public static BoletoServiceImpl getInstance() {
			
			if (instance == null) {
				instance = new BoletoServiceImpl();
			}
			
			return instance;
		}
		
		@Override
		public void cadastrar(Boleto boleto) {
			try {
				boletoDAO.salvar(boleto, getEntityManager());
			} catch (Exception e) {
				e.printStackTrace();
				getEntityManager().getTransaction().rollback();
			} finally {
				closeEntityManager();
			}
		}
		
		@Override
		public void atualizar(Boleto boleto) {
			try {
				boletoDAO.atualizar(boleto, getEntityManager());
			} catch (Exception e) {
				getEntityManager().getTransaction().rollback();
			} finally {
				closeEntityManager();
			}
			
		}

		@Override
		public void remover(Long id) {
			try {
				boletoDAO.remover(id, getEntityManager());
			} catch (Exception e) {
				e.printStackTrace();
				getEntityManager().getTransaction().rollback();
			} finally {
				closeEntityManager();
			}
			
		}

		@Override
		public Boleto obter(Long id) {
			Boleto boleto = null;
			
			try {
				boleto = boletoDAO.obterPorId(id, getEntityManager());
			} catch (Exception e) {
			} finally {
				closeEntityManager();
			}
			
			return boleto;
		}

		@Override
		public List<Boleto> listar() {
			List<Boleto> boletos = null;
			
			try {
				boletos = boletoDAO.listar(getEntityManager());
			} catch (Exception e) {
			} finally {
				closeEntityManager();
			}
			
			return boletos;
	}
}
