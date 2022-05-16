package br.com.fiap.service.impl;

import java.util.List;
import br.com.fiap.dao.impl.itemPedidoDAOImpl;
import br.com.fiap.entity.itemPedido;
import br.com.fiap.service.GenericService;

	public class ItemPedidoServiceImpl extends GenericService<itemPedido, Long> {

		private static ItemPedidoServiceImpl instance = null;
		
		private itemPedidoDAOImpl itemPedidoDAO;
		
		private ItemPedidoServiceImpl() {
			itemPedidoDAO = itemPedidoDAOImpl.getInstance();
		}
		
		public static ItemPedidoServiceImpl getInstance() {
			
			if (instance == null) {
				instance = new ItemPedidoServiceImpl();
			}
			
			return instance;
		}
		
		@Override
		public void cadastrar(itemPedido itemPedido) {
			try {
				itemPedidoDAO.salvar(itemPedido, getEntityManager());
			} catch (Exception e) {
				e.printStackTrace();
				getEntityManager().getTransaction().rollback();
			} finally {
				closeEntityManager();
			}
		}
		
		@Override
		public void atualizar(itemPedido itemPedido) {
			try {
				itemPedidoDAO.atualizar(itemPedido, getEntityManager());
			} catch (Exception e) {
				getEntityManager().getTransaction().rollback();
			} finally {
				closeEntityManager();
			}
			
		}

		@Override
		public void remover(Long id) {
			try {
				itemPedidoDAO.remover(id, getEntityManager());
			} catch (Exception e) {
				e.printStackTrace();
				getEntityManager().getTransaction().rollback();
			} finally {
				closeEntityManager();
			}
			
		}

		@Override
		public itemPedido obter(Long id) {
			itemPedido itemPedido = null;
			
			try {
				itemPedido = itemPedidoDAO.obterPorId(id, getEntityManager());
			} catch (Exception e) {
			} finally {
				closeEntityManager();
			}
			
			return itemPedido;
		}

		@Override
		public List<itemPedido> listar() {
			List<itemPedido> itemPedidos = null;
			
			try {
				itemPedidos = itemPedidoDAO.listar(getEntityManager());
			} catch (Exception e) {
			} finally {
				closeEntityManager();
			}
			
			return itemPedidos;
	}
}

