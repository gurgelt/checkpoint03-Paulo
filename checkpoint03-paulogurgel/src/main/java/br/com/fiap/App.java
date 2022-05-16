package br.com.fiap;

import br.com.fiap.service.impl.PedidoServiceImpl;
import br.com.fiap.service.impl.ProdutoServiceImpl;

public class App {
	
	public static void main(String[] args) {
		
		PedidoServiceImpl pedidoService = PedidoServiceImpl.getInstance();
		ProdutoServiceImpl produtoService = ProdutoServiceImpl.getInstance();
		
		System.out.println("=============== Listar pedidos (CPF) ===============");
		
		pedidoService.listarPorCPF("333.333.333-33").forEach(System.out::println);
		
		System.out.println("=============== Listar produtos (VALOR) ===============");
		
		produtoService.listarPorValor(200).forEach(System.out::println);
	}

}
