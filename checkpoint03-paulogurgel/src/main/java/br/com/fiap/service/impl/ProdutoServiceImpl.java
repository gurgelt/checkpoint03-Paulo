package br.com.fiap.service.impl;

import java.util.List;
import br.com.fiap.dao.impl.ProdutoDAOImpl;
import br.com.fiap.entity.Produto;
import br.com.fiap.service.GenericService;

	public class ProdutoServiceImpl extends GenericService<Produto, Long> {

		private static ProdutoServiceImpl instance = null;
		
		private ProdutoDAOImpl produtoDAO;
		
		private ProdutoServiceImpl() {
			produtoDAO = ProdutoDAOImpl.getInstance();
		}
		
		public static ProdutoServiceImpl getInstance() {
			
			if (instance == null) {
				instance = new ProdutoServiceImpl();
			}
			
			return instance;
		}
		
		@Override
		public void cadastrar(Produto produto) {
			try {
				produtoDAO.salvar(produto, getEntityManager());
			} catch (Exception e) {
				e.printStackTrace();
				getEntityManager().getTransaction().rollback();
			} finally {
				closeEntityManager();
			}
		}
		
		@Override
		public void atualizar(Produto produto) {
			try {
				produtoDAO.atualizar(produto, getEntityManager());
			} catch (Exception e) {
				getEntityManager().getTransaction().rollback();
			} finally {
				closeEntityManager();
			}
			
		}

		@Override
		public void remover(Long id) {
			try {
				produtoDAO.remover(id, getEntityManager());
			} catch (Exception e) {
				e.printStackTrace();
				getEntityManager().getTransaction().rollback();
			} finally {
				closeEntityManager();
			}
			
		}

		@Override
		public Produto obter(Long id) {
			Produto produto = null;
			
			try {
				produto = produtoDAO.obterPorId(id, getEntityManager());
			} catch (Exception e) {
			} finally {
				closeEntityManager();
			}
			
			return produto;
		}

		@Override
		public List<Produto> listar() {
			List<Produto> produtos = null;
			
			try {
				produtos = produtoDAO.listar(getEntityManager());
			} catch (Exception e) {
			} finally {
				closeEntityManager();
			}
			
			return produtos;
	}
		
		public List<Produto> listarPorValor(int valor) {
			List<Produto> produtos = null;
			
			try {
				produtos = produtoDAO.listarPorValor(valor, getEntityManager());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeEntityManager();
			}
			
			return produtos;
		}
}

